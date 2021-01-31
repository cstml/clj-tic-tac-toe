{pkgs ? import <nixpkgs> { }}:
pkgs.mkShell{
  name = "clojure-tic-tac-toe";
  buildInputs = with pkgs;[
    clojure
    leiningen
    emacs26Packages.magit
    emacs26Packages.paredit
  ];
  shellHook = ''
    gsettings set org.gnome.desktop.wm.preferences audible-bell false
    emacs &  
  '';
}
