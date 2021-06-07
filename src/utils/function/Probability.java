package utils.function;

import java.util.Random;

import static java.lang.Math.pow;

public enum Probability {
    Probability() {};

    public static double paretoVariate(Random generator, double alpha) {
        // Based on python random library
        // Pareto distribution.  alpha is the shape parameter.
        // Jain, pg. 495
        double u = 1.0 - generator.nextDouble();
        return 1.0 / pow(u, 1.0 / alpha);
    }

    public static double restrictValueToInterval(double x, double min, double max) {
        return (x - min) / (max - min);
    }

    public static int generateAttributeValue() {
        double u = Math.random();
        double a = .3;
        double l = 1;
        double h = 100;
        return Math.toIntExact(Math.round(
                pow(
                        -(pow(u * h, a) - pow(u * l, a) - pow(h, a))
                                /
                                (pow(h * l, a))
                        , -1 / a)));
    }
}
