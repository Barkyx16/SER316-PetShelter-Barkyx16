package edu.asu.ser316.petshelter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimulationTest {

  @Test
  void T_Q4_runSimulation_executesWithoutCrashing() {
    SimulationRunner runner = new SimulationRunner();

    assertDoesNotThrow(() -> runner.runOneWeek());
  }
}
