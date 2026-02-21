package edu.asu.ser316.petshelter;

public interface AnimalFactory {
  Animal createAnimal(String species, int age, String healthStatus);
}
