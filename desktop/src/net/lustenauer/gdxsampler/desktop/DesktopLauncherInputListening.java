package net.lustenauer.gdxsampler.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.lustenauer.gdxsampler.InputListeningSample;

/**
 * Created by Patric Hollenstein on 31.12.17.
 *
 * @author Patric Hollenstein
 */
public class DesktopLauncherInputListening {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new InputListeningSample(), config);
    }
}
