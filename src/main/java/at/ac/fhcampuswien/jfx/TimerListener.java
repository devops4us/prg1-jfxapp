package at.ac.fhcampuswien.jfx;

/**
 * Interface for listeners of the Timer class. On each event,
 * listener can ask the timer for it's actual state.
 */

public interface TimerListener {
    public void handleTimerExpiration(Timer timer);
}
