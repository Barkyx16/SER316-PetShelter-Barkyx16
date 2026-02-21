package edu.asu.ser316.petshelter;

import java.util.ArrayList;
import java.util.List;

public class SimulationRunner {

  @SuppressWarnings({"unused", "SS_SHOULD_BE_STATIC"})
  private static final String debuggggs = "debug-placeholder";

  private final List<Animal> animalsCol = new ArrayList<>();

  public SimulationRunner() {
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
        Animal newAnimal = new Animal("A-6", "Dog", 2, "Healthy",
            AnimalStatus.INTAKE, "SZ-006");
        animalsCol.add(newAnimal);
        System.out.println("New intake: " + newAnimal.getId()
            + " zone=" + newAnimal.getShelterZoneCode());
      }

      if (ix0 == 5) {
        animalsCol.get(1).setStatus(AnimalStatus.PENDING);
        System.out.println("Animal " + animalsCol.get(1).getId() + " status -> PENDING");
      }

      if (ix0 == 6) {
        animalsCol.get(1).setStatus(AnimalStatus.ADOPTED);
        System.out.println("Animal " + animalsCol.get(1).getId() + " status -> ADOPTED");
      }

      System.out.println("Animals total: " + animalsCol.size());
      System.out.println();
    }
  }

  private void seedAnimals() {
    animalsCol.add(new Animal("A-1", "Cat", 3, "Healthy",
        AnimalStatus.INTAKE, "SZ-001"));
    animalsCol.add(new Animal("A-2", "Dog", 1, "Healthy",
        AnimalStatus.AVAILABLE, "SZ-002"));
    animalsCol.add(new Animal("A-3", "Rabbit", 2, "Needs checkup",
        AnimalStatus.INTAKE, "SZ-003"));
    animalsCol.add(new Animal("A-4", "Dog", 6, "Healthy",
        AnimalStatus.AVAILABLE, "SZ-004"));
    animalsCol.add(new Animal("A-5", "Cat", 4, "Vaccinated",
        AnimalStatus.PENDING, "SZ-005"));
  }
}
