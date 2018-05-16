package com.example.course_cs_game.CardGame;

import android.os.CountDownTimer;

/**
 * This class uses the native CountDownTimer to
 * create a timer which could be paused and then
 * started again from the previous point
 * It is necessary for pausing timer when activity
 * isn't in focus
 */

public abstract class CountDownTimerPausable {

    private CountDownTimer countDownTimer = null;

    private long countDownInterval;
    private long millisRemaining;
    private boolean isPaused = true;

    CountDownTimerPausable(long millisRemaining, long countDownInterval) {
        super();
        this.countDownInterval = countDownInterval;
        this.millisRemaining = millisRemaining;
    }

    private void createCountDownTimer(){
        countDownTimer = new CountDownTimer(millisRemaining,countDownInterval) {

            @Override
            public void onTick(long millisUntilFinished) {
                millisRemaining = millisUntilFinished;
                CountDownTimerPausable.this.onTick(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                CountDownTimerPausable.this.onFinish();
            }
        };
    }

    /**
     * Is called on regular interval and saves the current state of the timer
     *
     * @param millisUntilFinished the amount of time until finished
     */
    public abstract void onTick(long millisUntilFinished);

    /**
     * Method called when the time is up
     */
    public abstract void onFinish();

    /**
     * Cancel the countdown.
     */
    public final void cancel(){
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
        this.millisRemaining = 0;
    }

    /**
     * Start or Resume the countdown
     *
     * @return CountDownTimerPausable current instance
     */
    public synchronized final CountDownTimerPausable start() {
        if (isPaused) {
            createCountDownTimer();
            countDownTimer.start();
            isPaused = false;
        }
        return this;
    }

    /**
     * Pauses the CountDownTimerPausable, so it could be resumed(start)
     * later from the same point where it was paused
     */
    public void pause() throws IllegalStateException {
        if(!isPaused) {
            countDownTimer.cancel();
        }
        isPaused = true;
    }
}
