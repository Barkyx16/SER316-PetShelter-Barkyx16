package edu.asu.ser316.petshelter;

import java.util.Objects;

public final class Animal {
  private final String id;
  private final String species;
  private final int age;
  private String healthStatus;
  private AnimalStatus status;
  private final String shelterZoneCode;

  public Animal(String id, String species, int age, String healthStatus, AnimalStatus status, String shelterZoneCode) {
    this.id = Objects.requireNonNull(id);
    this.species = Objects.requireNonNull(species);
    this.age = age;
    this.healthStatus = Objects.requireNonNull(healthStatus);
    this.status = Objects.requireNonNull(status);
    this.shelterZoneCode = Objects.requireNonNull(shelterZoneCode);

    if (!shelterZoneCode.matches("^SZ-\\d{3}$")) {
      throw new IllegalArgumentException("shelterZoneCode must match SZ-XXX (3 digits)");
    }
  }

  public String getId() {
    return id;
  }

  public String getSpecies() {
    return species;
  }

  public int getAge() {
    return age;
  }

  public String getHealthStatus() {
    return healthStatus;
  }

  public void setHealthStatus(String healthStatus) {
    this.healthStatus = Objects.requireNonNull(healthStatus);
  }

  public AnimalStatus getStatus() {
    return status;
  }

  public void setStatus(AnimalStatus status) {
    this.status = Objects.requireNonNull(status);
  }

  public String getShelterZoneCode() {
    return shelterZoneCode;
  }

  @Override
  public String toString() {
    return "Animal{"
        + "id='" + id + '\''
        + ", species='" + species + '\''
        + ", age=" + age
        + ", healthStatus='" + healthStatus + '\''
        + ", status=" + status
        + ", shelterZoneCode='" + shelterZoneCode + '\''
        + '}';
  }
}
