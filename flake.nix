{
  description = "Description for the project";

  inputs = {
    flake-parts.url = "github:hercules-ci/flake-parts";
    flake-parts.inputs.nixpkgs-lib.follows = "nixpkgs";
    nixpkgs.url = "github:NixOS/nixpkgs";
    treefmt-nix.url = "github:numtide/treefmt-nix";
    pre-commit-hooks-nix.url = "github:cachix/pre-commit-hooks.nix";
  };

  outputs = inputs @ {
    self,
    flake-parts,
    ...
  }:
    flake-parts.lib.mkFlake {inherit inputs;} {
      imports = [
        inputs.treefmt-nix.flakeModule
        inputs.pre-commit-hooks-nix.flakeModule
      ];
      systems = ["x86_64-linux" "aarch64-linux" "aarch64-darwin" "x86_64-darwin"];
      perSystem = {
        config,
        self',
        inputs',
        pkgs,
        system,
        ...
      }: {
        treefmt.programs = {
          alejandra.enable = true;
          cabal-fmt.enable = true;
          google-java-format.enable = true;
        };
        treefmt.projectRootFile = "flake.nix";
        pre-commit.settings.hooks = {
          treefmt.enable = true;
        };
        devShells.default = let
          runtimeLibs = with pkgs; [glfw libGL openal libpulseaudio];
        in
          pkgs.mkShell {
            packages = with pkgs; [(gradle.override {java = jdk21;})];
            buildInputs = runtimeLibs;
            JAVA_HOME = "${pkgs.jdk21}";
            LD_LIBRARY_PATH = "/run/opengl-driver/lib:/run/opengl-driver-32/lib:${pkgs.lib.makeLibraryPath runtimeLibs}";
          };
      };
      flake = {
      };
    };
}
