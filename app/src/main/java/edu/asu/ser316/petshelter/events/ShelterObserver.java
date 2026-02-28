package edu.asu.ser316.petshelter.events;

/**
 * Observer interface for receiving shelter events.
 */
public interface ShelterObserver {
    void onEvent(ShelterEvent event);
}
