# Farkle Dice Game — Course Project

## Overview
Java / JavaFX implementation of the Farkle dice game, featuring a graphical interface,
six dice, scores, turn controls, three computer opponents, and risk hints based on
the probability of rolling no scoring dice.

## Technologies
- Java
- JavaFX
- Object-oriented programming
- UML class diagrams and flowcharts

## Features reflected in the supplied source files
- Human player and three computer opponents (`GamePanel.java`)
- Dice rolling, selection and locking (`Die.java`, `DicePane.java`)
- Rules-based scoring, banking points and farkle detection (`Score.java`)
- Easier and harder computer-turn strategies (`Computer.java`)
- Risk hint calculations (`Player.java`, `TakeTurn.java`)
- GUI controls and scoreboard (`Main.java`, `ButtonPanes.java`, `ScoreBoard.java`)

## Files
- `src/application/` — 15 provided Java source files
- `../../screenshots/farkle-uml.png` — supplied UML class diagram
- `../../screenshots/farkle-flowchart.png` — supplied game flowchart
- `GAME_INSTRUCTIONS.txt` — supplied game rules

## Running and verification
The source declares `package application` and imports JavaFX.
A JavaFX-enabled JDK/runtime and properly configured resources are needed.
**Important:** The provided `Main.java` expects `application.css`, and `Die.java`
expects `/images/Dice1.png` through `Dice6.png`; these resource files were not
among the uploaded materials. Add the original assets before attempting a full
GUI run. This is a source-and-design showcase, not a verified runnable build.
Screenshot evidence presently includes UML and flowchart, not an actual running game.

## Credit
Source and diagrams were supplied by Jaylon Pham for his course-project portfolio.
Specific individual vs. team contributions have not yet been verified.
