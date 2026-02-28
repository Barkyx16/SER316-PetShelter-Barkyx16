package edu.asu.ser316.petshelter;

public interface AnimalObserver {
  void onStatusChanged(Animal animal, AnimalStatus oldStatus, AnimalStatus newStatus);
}

