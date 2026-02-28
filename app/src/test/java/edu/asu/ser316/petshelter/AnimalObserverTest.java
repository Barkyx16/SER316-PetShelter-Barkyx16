package edu.asu.ser316.petshelter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AnimalObserverTest {

  static class TestObserver implements AnimalObserver {
    AnimalStatus oldStatus;
    AnimalStatus newStatus;
    boolean triggered = false;

    @Override
    public void onStatusChanged(Animal animal, AnimalStatus oldStatus, AnimalStatus newStatus) {
      this.oldStatus = oldStatus;
      this.newStatus = newStatus;
      triggered = true;
    }
  }

  @Test
  void T_Q3_statusChange_notifiesObserver() {
    Animal animal = new Animal("A-1", "Cat", 3, "Healthy", AnimalStatus.INTAKE, "SZ-001");

    TestObserver observer = new TestObserver();
    animal.addObserver(observer);

    animal.setStatus(AnimalStatus.AVAILABLE);

    assertTrue(observer.triggered);
    assertEquals(AnimalStatus.INTAKE, observer.oldStatus);
    assertEquals(AnimalStatus.AVAILABLE, observer.newStatus);
  }
}
