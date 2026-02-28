package edu.asu.ser316.petshelter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FactoryTest {

  @Test
  void T_Q1_createAnimal_hasExpectedFields() {
    AnimalFactory factory = new BasicAnimalFactory();

    Animal animal = factory.createAnimal("Dog", 2, "Healthy");

    assertNotNull(animal);
    assertNotNull(animal.getId());
    assertEquals("Dog", animal.getSpecies());
    assertEquals(2, animal.getAge());
    assertEquals("Healthy", animal.getHealthStatus());
    assertEquals(AnimalStatus.INTAKE, animal.getStatus());

    // Zone code should match SZ-XXX format (validated in Animal constructor)
    assertTrue(animal.getShelterZoneCode().matches("^SZ-\\d{3}$"));
  }
}
