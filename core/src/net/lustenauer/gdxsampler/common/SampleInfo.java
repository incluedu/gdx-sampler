package net.lustenauer.gdxsampler.common;

/**
 * Created by Patric Hollenstein on 02.01.18.
 *
 * @author Patric Hollenstein
 */
public class SampleInfo {
    private final String name;
    private final Class<? extends SampleBase> sampleClass;

    public SampleInfo(Class<? extends SampleBase> sampleClass) {
        this.sampleClass = sampleClass;
        name = sampleClass.getSimpleName();
    }

    public String getName() {
        return name;
    }

    public Class<?> getSampleClass() {
        return sampleClass;
    }
}
