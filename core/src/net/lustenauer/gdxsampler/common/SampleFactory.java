package net.lustenauer.gdxsampler.common;

import com.badlogic.gdx.utils.reflect.ClassReflection;

/**
 * Created by Patric Hollenstein on 02.01.18.
 *
 * @author Patric Hollenstein
 */
public class SampleFactory {

    public static SampleBase newSample(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name param is required");
        }

        SampleInfo info = SampleInfos.find(name);

        try {
            return (SampleBase) ClassReflection.newInstance(info.getSampleClass());
        } catch (Exception e) {
            throw new RuntimeException("Cannot create sample with name= " + name, e);
        }
    }


    private SampleFactory() {
    }
}
