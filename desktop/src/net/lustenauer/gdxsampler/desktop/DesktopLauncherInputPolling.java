package net.lustenauer.gdxsampler.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.lustenauer.gdxsampler.InputPollingSample;

/**
 * Created by Patric Hollenstein on 31.12.17.
 *
 * @author Patric Hollenstein
 */
public class DesktopLauncherInputPolling {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new InputPollingSample(), config);
    }
}
