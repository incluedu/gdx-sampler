package net.lustenauer.gdxsampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import net.lustenauer.gdxsampler.common.SampleBase;
import net.lustenauer.gdxsampler.common.SampleInfo;
import net.lustenauer.gdxsampler.utils.GdxUtils;

/**
 * Created by Patric Hollenstein on 10.01.18.
 *
 * @author Patric Hollenstein
 */
public class AssetManagerSample extends SampleBase {
    private static final Logger log = new Logger(AssetManagerSample.class.getName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(AssetManagerSample.class);

    public static final String BACKGROUND_BLUE = "raw/background-blue.png";
    public static final String GREEN_CIRCLE = "raw/circle-green.png";
    public static final String RED_CIRCLE = "raw/circle-red.png";
    public static final String FONT = "fonts/oswald-32.fnt";

    private static final float WIDTH = 1080f;
    private static final float HEIGHT = 720f;

    private AssetManager assetManager;
    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;

    private Texture backgroundBlue;
    private Texture greenCircle;
    private Texture redCircle;
    private BitmapFont font;


    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        assetManager = new AssetManager();
        assetManager.getLogger().setLevel(Logger.DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(WIDTH, HEIGHT, camera);
        batch = new SpriteBatch();

        // load assets
        assetManager.load(BACKGROUND_BLUE, Texture.class);
        assetManager.load(GREEN_CIRCLE, Texture.class);
        assetManager.load(RED_CIRCLE, Texture.class);
        assetManager.load(FONT, BitmapFont.class);


        // blocks until all resources are loaded into memory
        assetManager.finishLoading();

        //get assets
        backgroundBlue = assetManager.get(BACKGROUND_BLUE);
        greenCircle = assetManager.get(GREEN_CIRCLE);
        redCircle = assetManager.get(RED_CIRCLE);
        font = assetManager.get(FONT);


    }

    @Override
    public void render() {
        GdxUtils.clearScreen();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.draw(backgroundBlue, 0, 0);
        batch.draw(greenCircle, 50, 50);
        batch.draw(redCircle, 200, 200);

        font.draw(batch, "AssetManagerSample", 500, 50);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        batch.dispose();
        assetManager.dispose();
    }
}
