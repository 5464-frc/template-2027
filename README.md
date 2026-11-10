# template-2027
basic implimentation of CommandV3 started for the 2026-2027 FRC season. </br>
started on WPILIB 2027 alpha 8, artifacts may exist 

- `Command` creation is abstracted to `CommandFactory` to avoid new programmers having to deal with lambda syntax and declaration.
- `*.bak` files were created with the project, and serve only as reference
- mise is used primarily for node version management and shell script wrapping. JDK is provided by WPILib, and shouldn't be specified there
- [FORMAT.sh](FORMAT.sh) should be periodically ran. the syntax highlighting is already specified in [.vscode/](.vscode/), but it's still a good habit
- compilation is tested on push, so please only do as such periodically (either upon request / at the end of session)
## examples
contents of the [examples/](src/main/java/first/examples) should **not** be used in production builds, they mainly serve to demonstrate implimentation and syntax.

## docs
javadocs syntax is used for functions, variables, and class declarations. compiled into html using dokka; for more information see [mise.toml](mise.toml)
## license
ECL2 applies to code written by Team 5464, WPILib and associated commons are still under their respective licensing
