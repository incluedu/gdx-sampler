package net.lustenauer.gdxsampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;
import net.lustenauer.gdxsampler.common.SampleBase;
import net.lustenauer.gdxsampler.common.SampleInfo;

public class ApplicationListenerSample extends SampleBase {
    private final Logger logger = new Logger(ApplicationListenerSample.class.getName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO= new SampleInfo(ApplicationListenerSample.class);

    private boolean renderInterrupted = true;

    @Override
    public void create() {
        // use to init and load resources
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        logger.debug("create() called");

    }

    @Override
    public void resize(int width, int height) {
        // used to handle setting a new screen size
        logger.debug("resize() width= " + width + " height= " + height);
    }

    @Override
    public void render() {
        // used to update and render the game elements called 60 times per second

        if (renderInterrupted) {
            logger.debug("render()");
            renderInterrupted = false;
        }
    }

    @Override
    public void pause() {
        // used to save game state when it loses focus, witch dose not involve the actual
        // game play being paused unless the develop wants it to pause
        logger.debug("pause()");
        renderInterrupted = true;
    }

    @Override
    public void resume() {
        // use to handle the game coming back from being paused and restores the state
        logger.debug("resume()");
        renderInterrupted = true;
    }

    @Override
    public void dispose() {
        // used to free resources and cleanup
        logger.debug("dispose()");
    }
}
