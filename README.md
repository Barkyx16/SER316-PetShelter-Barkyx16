# SER316 Pet Shelter Simulation (Deliverable A)

## Project Overview

This project is a small Java simulation of a pet shelter operating over time. The program will model animals entering the shelter, being cared for, and eventually being adopted. Each cycle of the simulation will print clear console output so it’s easy to follow what is happening in the system and how the shelter’s state changes.

## Planned Design Patterns

**Factory Method**
The Factory Method pattern will be used to create Animal objects such as dogs and cats during intake. This keeps object creation organized in one place and makes it easy to add new animal types later without rewriting the main simulation logic.

**Observer**
An Observer-style event system will be used to handle important shelter events like intake, adoption, health checks, and capacity warnings. Different parts of the system (logging, statistics, alerts) can react to events without being tightly connected to the main simulation.

## Integration Strategy

During each simulation cycle, events will occur such as new animals arriving or animals being adopted. When an intake event happens, the Factory will create the animal, and that event will then be broadcast through the Observer system. Observers will respond by printing messages, updating shelter statistics, and checking capacity conditions. This allows both patterns to work together naturally rather than independently.

## Requirements Focus (planned functional features)

1. The system will intake animals and assign them a unique ID.
2. Animals will store basic information such as type, name, age, and health status.
3. The simulation will run in time steps and update the shelter state each cycle.
4. Animals can be adopted and removed from the shelter.
5. The system will monitor shelter capacity and warn when it is near full.
6. Each cycle will display important events and state changes in the console.
7. The program will print a summary at the end of the simulation showing results.

## Concerns / Questions

* Determining how detailed the health system should be without making the program overly complex.
* Deciding whether adoptions should be random or follow specific rules.
* Making sure the two design patterns feel naturally connected rather than artificially added.

