package net.lustenauer.gdxsampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import net.lustenauer.gdxsampler.common.SampleBase;
import net.lustenauer.gdxsampler.common.SampleInfo;
import net.lustenauer.gdxsampler.utils.GdxUtils;

/**
 * Created by Patric Hollenstein on 07.01.18.
 *
 * @author Patric Hollenstein
 */
public class BitmapFontSample extends SampleBase {
    public static final SampleInfo SAMPLE_INFO = new SampleInfo(BitmapFontSample.class);

    private static final float WIDTH = 1080f;
    private static final float HEIGHT = 720f;

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont effectFont;
    private BitmapFont uiFont;
    private GlyphLayout glyphLayout;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(WIDTH, HEIGHT, camera);
        batch = new SpriteBatch();
        effectFont = new BitmapFont(Gdx.files.internal("fonts/effect_arial-32.fnt"));
        uiFont = new BitmapFont(Gdx.files.internal("fonts/arial-32.fnt"));
        uiFont.getData().markupEnabled = true;
        glyphLayout = new GlyphLayout();
    }

    @Override
    public void render() {

        GdxUtils.clearScreen();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();

        batch.end();
    }

    private void draw() {
        String text1 = "Using Bitmap Font";
        effectFont.draw(batch, text1, 20, HEIGHT, 100, 0, true);

        String text2 = "[#FF0000]Bitmap [GREEN]FONTS [YELLOW]are [BLUE]cool!";
        glyphLayout.setText(uiFont, text2);
        uiFont.draw(batch, text2, (WIDTH - glyphLayout.width) / 2f, (HEIGHT - glyphLayout.height) / 2f);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }


    @Override
    public void dispose() {
        batch.dispose();
        effectFont.dispose();
        uiFont.dispose();
    }
}
