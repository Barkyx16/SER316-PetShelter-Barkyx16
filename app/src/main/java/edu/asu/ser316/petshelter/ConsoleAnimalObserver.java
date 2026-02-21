package edu.asu.ser316.petshelter;

public class ConsoleAnimalObserver implements AnimalObserver {

  @Override
  public void onStatusChanged(Animal animal, AnimalStatus oldStatus, AnimalStatus newStatus) {
    if (oldStatus != newStatus) {
      System.out.println("Observer: " + animal.getId() + " status " + oldStatus + " -> " + newStatus);
    }
  }
}
