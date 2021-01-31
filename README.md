# tic-tac-toe
## clj style

Good old Tic-Tac-Toe, a favourite of mine that I try and implement all
the time to test my understanding of new concepts. This was a fun
little project to implement in clojure. It is more of a stub than a
finalised project but nevertheless it works. There are still many
things left to be done on it ofc.

## Installation

- Clone the repository and run with `lein run`. 
- I am looking into
creating a  nix derivation  for it. 
- If you just want to run it
download the `jar` file and run it locally with

```bash
   java -jar tic-tac-toe-0.1.0-standalone.jar [args]
```

## How to Play

1. `x` goes first
2. put down a number from 1 to 9 each number being the position you want to play. The positions are as follows:
```text
1 2 3
4 5 6
7 8 9
```
3. `o` goes after
4. loop on

## Known issues (will not fix - probably)

- draws are not detected
- no input sanitisation
- there are no tests set up

## License

Copyright © 2021

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
