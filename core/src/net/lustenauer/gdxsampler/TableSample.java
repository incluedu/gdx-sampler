package net.lustenauer.gdxsampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import net.lustenauer.gdxsampler.common.CustomActor;
import net.lustenauer.gdxsampler.common.SampleBase;
import net.lustenauer.gdxsampler.common.SampleInfo;
import net.lustenauer.gdxsampler.utils.GdxUtils;

/**
 * Created by Patric Hollenstein on 13.01.18.
 *
 * @author Patric Hollenstein
 */
public class TableSample extends SampleBase {
    private static final Logger log = new Logger(TableSample.class.getName(), Logger.DEBUG);
    public static final SampleInfo SAMPLE_INFO = new SampleInfo(TableSample.class);

    private static final float WORLD_WIDTH = 1080;
    private static final float WORLD_HEIGHT = 720;

    private Viewport viewport;

    private Stage stage;
    private Texture texture;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        viewport = new FillViewport(WORLD_WIDTH, WORLD_HEIGHT);
        stage = new Stage(viewport);

        texture = new Texture(Gdx.files.internal("raw/custom-actor.png"));

        initUi();

    }

    private void initUi() {
        Table table = new Table();
        table.defaults().space(20);

        for (int i = 0; i < 6; i++) {
            CustomActor customActor = new CustomActor(new TextureRegion(texture));
            customActor.setSize(180,60);
            customActor.setRotation(45f);
            table.add(customActor);
            table.row();
        }

        table.center();
        table.setFillParent(true);
        table.pack();
        stage.addActor(table);
        stage.setDebugAll(true);

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        GdxUtils.clearScreen();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        texture.dispose();
    }

}
