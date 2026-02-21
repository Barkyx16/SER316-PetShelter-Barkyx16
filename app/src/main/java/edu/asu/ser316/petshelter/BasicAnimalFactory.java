package edu.asu.ser316.petshelter;

public class BasicAnimalFactory implements AnimalFactory {

  private int nextAnimalNumber = 6;

  @Override
  public Animal createAnimal(String species, int age, String healthStatus) {
    String id = "A-" + nextAnimalNumber;
    String shelterZoneCode = toZoneCode(nextAnimalNumber);

    nextAnimalNumber++;

    return new Animal(id, species, age, healthStatus, AnimalStatus.INTAKE, shelterZoneCode);
  }

  private String toZoneCode(int number) {
    String numberPart;
    if (number < 10) {
      numberPart = "00" + number;
    } else if (number < 100) {
      numberPart = "0" + number;
    } else {
      numberPart = String.valueOf(number);
    }
    return "SZ-" + numberPart;
  }
}
