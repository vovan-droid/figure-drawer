# Figures-drawer

## Prerequisites

- Java 8
- Maven

## Overview

This is my (as a student) pet project „Figure Drawer“ that allows the user to draw any figure on a console (for example any kind of
triangles, or a rectangle or even a house) with just knowing a size of a figure - all the calculation and actual drawing
is done by the program itself.

For now the drawing is happening in the console. But the service is written in a way that it can be easily expandable to
also have a UI interface.

````
   *
  * *
 *   *
*******
**   **
* * * *
*  *  *
* * * *
**   **
*******
````

## Why this project

I intentionally chose this „simple“ topic for a project with a minimum business logic, because I wanted to focus on a
technical richness of the project rather than showing off in richness of business features. My goal here was to focus on
deepening my knowledge in a programming language Java, design patterns and engineering practices.

## Goals

To develop step-by-step architectural (design) solutions that solve the task “draw a house”,
where each subsequent level becomes progressively more efficient, has less lines of code, and is more maintainable.

Each level increases the level of abstraction and applies system-design and architectural patterns,
gradually moving from raw imperative logic to a declarative, pattern-driven approach.

### Step 1 — drawHouseLvl1(size)

- Uses a raw imperative algorithm with deeply nested loops and direct System.out.print calls
- No reuse, no separation of concerns: drawing logic and printing mechanics are fully coupled
- The method is large, monolithic, and difficult to modify or extend
- **40 lines of business logic**

### Step 2 — drawHouseLvl2(size)

- Introduces a drawing service abstraction (PatternDrawerService)
- Low-level printing is encapsulated into reusable operations:
    - printDottedLine(...)
    - printSolidLine(size)
- Still relies on explicit for loops to express repetition and symmetry
- Improves readability and reduces duplication, but control flow is still manual
- **13 lines of business logic**

### Step 3 — drawHouseLvl3(size)

- Replaces most loops with pattern-based drawing primitives
- Repetition is expressed declaratively via:
    - printDottedLines(count, dot(...), dot(...), …)
- Introduces parameterized dot deltas to encode iteration rules inside reusable methods
- The method becomes a sequence of what to draw, not how to iterate
- **7 lines of business logic**

### Step 4 — drawHouseLvl4(size)

- Moves to a coordinate-driven, geometry-aware API
- Uses explicit anchor points:
    - point(x, y)
    - printDottedLinesEx(count, point(...), point(...), …)
- Drawing logic is expressed in terms of structure and symmetry, not iteration
- HouseDrawerService acts as a high-level orchestrator; complexity lives in the drawing engine
- **4 lines of business logic**

## Main classes

1. PatternDrawerService - a core class, containing methods - atomic „patterns“, from which any figure can be potentially
   built.
   Already optimised for building complicated lines.
2. Drawer classes - a higher level abstraction above Pattern class. Used for building actual figures using patterns from
   Pattern
   class.
    - FigureDrawerService - prints debugging figures (triangles, lines)
    - HouseDrawerService - print an actual house, has 4 methods with different levels of complexity as mentioned above.
3. Runner - a „starting point“ of our application, where we just specify what kind of figure we want to draw.
   Each class is developed using Client-Service pattern: For example a Runner class is a client,
   and a DrawerService is its service, and DrawerService itself is also a client for PatternService class.

![](img/classes-diagrams.jpg)

## Technologies that were used

- Java features
    - OOP
    - Abstract, inner, nested classes
    - Stream API
    - Call chaining
- Design patterns:
    - Builder
    - Factory method
    - Strategy - for testing purpose
    - Singleton (was eventually removed from the project)
    - To be added: Unit tests, using input/output Stream
- Maven for managing dependencies
- JUnit 5 for tests (to be added)
- UML diagrams
