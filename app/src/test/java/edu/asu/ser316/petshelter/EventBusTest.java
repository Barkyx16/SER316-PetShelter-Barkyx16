package edu.asu.ser316.petshelter;

import static org.junit.jupiter.api.Assertions.*;

import edu.asu.ser316.petshelter.events.IntakeEvent;
import edu.asu.ser316.petshelter.events.ShelterEventBus;
import edu.asu.ser316.petshelter.observers.ShelterStatsObserver;
import org.junit.jupiter.api.Test;

public class EventBusTest {

  @Test
  void T_Q2_publishIntakeEvent_updatesStatsObserver() {
    ShelterEventBus bus = new ShelterEventBus();
    ShelterStatsObserver stats = new ShelterStatsObserver();

    bus.registerObserver(stats);

    bus.publish(new IntakeEvent("A-99", 1, "SZ-999"));

    assertEquals(1, stats.getIntakeCount());
    assertEquals(0, stats.getAdoptionCount());
    assertEquals(0, stats.getCapacityWarningCount());
  }
}
