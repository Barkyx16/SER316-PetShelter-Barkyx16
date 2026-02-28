package edu.asu.ser316.petshelter;

import java.util.ArrayList;
import java.util.List;

import edu.asu.ser316.petshelter.events.AdoptionEvent;
import edu.asu.ser316.petshelter.events.CapacityWarningEvent;
import edu.asu.ser316.petshelter.events.IntakeEvent;
import edu.asu.ser316.petshelter.events.ShelterEventBus;
import edu.asu.ser316.petshelter.observers.ConsoleLoggerObserver;
import edu.asu.ser316.petshelter.observers.ShelterStatsObserver;

public class SimulationRunner {

  @SuppressWarnings({"unused", "SS_SHOULD_BE_STATIC"})
  private static final String debuggggs = "debug-placeholder";

  private final List<Animal> animalsCol = new ArrayList<>();
  private final AnimalFactory animalFactory = new BasicAnimalFactory();
  private final AnimalObserver observer = new ConsoleAnimalObserver();

  // NEW OBSERVER SYSTEM
  private final ShelterEventBus eventBus = new ShelterEventBus();
  private final ShelterStatsObserver statsObserver = new ShelterStatsObserver();

  public SimulationRunner() {
    // register observers for event bus
    eventBus.registerObserver(new ConsoleLoggerObserver());
    eventBus.registerObserver(statsObserver);

    System.out.println("Observer event system initialized.");

    seedAnimals();
  }

  public void runOneWeek() {
    for (int ix0 = 1; ix0 <= 7; ix0++) {
      System.out.println("SIMS " + RomanNumeral.toRoman(ix0));

      if (ix0 == 2) {
        animalsCol.get(0).setStatus(AnimalStatus.AVAILABLE);
        System.out.println("Animal " + animalsCol.get(0).getId() + " status -> AVAILABLE");
      }

      if (ix0 == 3) {
        Animal newAnimal = animalFactory.createAnimal("Dog", 2, "Healthy");
        newAnimal.addObserver(observer);
        animalsCol.add(newAnimal);

        System.out.println("Factory created intake: " + newAnimal.getId()
            + " zone=" + newAnimal.getShelterZoneCode());

        // PUBLISH INTAKE EVENT
        eventBus.publish(new IntakeEvent(
            newAnimal.getId(),
            ix0,
            newAnimal.getShelterZoneCode()
        ));
      }

      if (ix0 == 5) {
        animalsCol.get(1).setStatus(AnimalStatus.PENDING);
        System.out.println("Animal " + animalsCol.get(1).getId() + " status -> PENDING");
      }

      if (ix0 == 6) {
        animalsCol.get(1).setStatus(AnimalStatus.ADOPTED);
        System.out.println("Animal " + animalsCol.get(1).getId() + " status -> ADOPTED");

        // PUBLISH ADOPTION EVENT
        eventBus.publish(new AdoptionEvent(
            animalsCol.get(1).getId(),
            ix0
        ));
      }

      // CAPACITY WARNING EXAMPLE
      if (animalsCol.size() > 5) {
        eventBus.publish(new CapacityWarningEvent("GENERAL", animalsCol.size(), 5));
      }

      System.out.println("Animals total: " + animalsCol.size());
      System.out.println();
    }

    // PRINT SUMMARY
    System.out.println(statsObserver.buildSummaryString());
  }

  private void seedAnimals() {
    Animal a1 = new Animal("A-1", "Cat", 3, "Healthy",
        AnimalStatus.INTAKE, "SZ-001");
    a1.addObserver(observer);
    animalsCol.add(a1);

    Animal a2 = new Animal("A-2", "Dog", 1, "Healthy",
        AnimalStatus.AVAILABLE, "SZ-002");
    a2.addObserver(observer);
    animalsCol.add(a2);

    Animal a3 = new Animal("A-3", "Rabbit", 2, "Needs checkup",
        AnimalStatus.INTAKE, "SZ-003");
    a3.addObserver(observer);
    animalsCol.add(a3);

    Animal a4 = new Animal("A-4", "Dog", 6, "Healthy",
        AnimalStatus.AVAILABLE, "SZ-004");
    a4.addObserver(observer);
    animalsCol.add(a4);

    Animal a5 = new Animal("A-5", "Cat", 4, "Vaccinated",
        AnimalStatus.PENDING, "SZ-005");
    a5.addObserver(observer);
    animalsCol.add(a5);
  }
}
