package at.ac.fhcampuswien.jfx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * A timer can be started and stopped. As log as it runs, a timer keeps track of the
 * amount of time it is in the running state. As long as it is up, the timer
 * will also propagate its actual state periodically to the registerded listener.
 */

public class Timer {

    public static final long DURATION = 5000;

    private long timeMillis;
    private EventHandler<ActionEvent> timerListener;

    public Timer(String timeString, EventHandler<ActionEvent> timerListener)
    {
        this.timerListener = timerListener;
        setTimeFromString(timeString==null?"0:0:0":timeString);
    }

    public void start()
    {
        Timeline timeline = new Timeline( new KeyFrame(
                Duration.millis(DURATION),
                timerListener));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void updateTime() {
        this.timeMillis+=DURATION;
    }

    private void setTimeFromString(String uptime)
    {
        String[] parts = uptime.split(":");
        this.timeMillis = Long.parseLong(parts[0])*60*60*1000
            + Long.parseLong(parts[1])*60*1000
                + Long.parseLong(parts[2])*1000;
    }

    public String getTimeAsString() {
        long hours= timeMillis /(60*60*1000);
        long minutes = (timeMillis -(hours*60*60*1000))/(60*1000);
        long seconds= (timeMillis -(hours*60*60*1000)-(minutes*60*1000))/1000;
        return String.format("%d:%d:%d", hours,minutes,seconds);
    }
}
