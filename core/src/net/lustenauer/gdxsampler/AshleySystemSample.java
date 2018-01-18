package net.lustenauer.gdxsampler;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import net.lustenauer.gdxsampler.ashley.component.PositionComponent;
import net.lustenauer.gdxsampler.ashley.component.SizeComponent;
import net.lustenauer.gdxsampler.ashley.component.TextureComponent;
import net.lustenauer.gdxsampler.ashley.system.RenderSystem;
import net.lustenauer.gdxsampler.common.SampleBase;
import net.lustenauer.gdxsampler.common.SampleInfo;
import net.lustenauer.gdxsampler.utils.GdxUtils;

/**
 * Created by Patric Hollenstein on 17.01.18.
 *
 * @author Patric Hollenstein
 */
public class AshleySystemSample extends SampleBase {
    private static final Logger log = new Logger(AshleySystemSample.class.getName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(AshleySystemSample.class);

    private static final float WORLD_WIDTH = 10.8f;
    private static final float WORLD_HEIGHT = 7.2f;

    private static final String LEVEL_BG = "raw/level-bg.png";
    private static final String CHARACTER = "raw/character.png";

    private AssetManager assetManager;
    private Viewport viewport;
    private SpriteBatch batch;
    private Engine engine;


    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        assetManager = new AssetManager();
        assetManager.getLogger().setLevel(Logger.DEBUG);

        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        batch = new SpriteBatch();
        engine = new Engine();

        assetManager.load(LEVEL_BG, Texture.class);
        assetManager.load(CHARACTER,Texture.class);
        assetManager.finishLoading();

        addBackground();
        addCharacter();

        engine.addSystem(new RenderSystem(viewport, batch));
    }

    private void addCharacter() {
        PositionComponent position = new PositionComponent();
        position.x = 1;
        position.y = 3;

        SizeComponent size = new SizeComponent();
        size.width = 2;
        size.height = 2;

        TextureComponent texture = new TextureComponent();
        texture.texture = assetManager.get(CHARACTER);


        Entity entity = new Entity();
        entity.add(position);
        entity.add(size);
        entity.add(texture);

        engine.addEntity(entity);
    }

    private void addBackground() {
        PositionComponent position = new PositionComponent();
        position.x = 0;
        position.y = 0;

        SizeComponent size = new SizeComponent();
        size.width = WORLD_WIDTH;
        size.height = WORLD_HEIGHT;

        TextureComponent texture = new TextureComponent();
        texture.texture = assetManager.get(LEVEL_BG);


        Entity entity = new Entity();
        entity.add(position);
        entity.add(size);
        entity.add(texture);

        engine.addEntity(entity);
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        GdxUtils.clearScreen();

        float delta = Gdx.graphics.getDeltaTime();
        engine.update(delta);

    }

    @Override
    public void dispose() {
        assetManager.dispose();
        batch.dispose();
    }
}
