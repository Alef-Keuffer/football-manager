package Utils.Function;

import java.util.Random;

public enum Probability {
    Probability() {};
    public static double paretoVariate(Random generator, double alpha) {
        double u = 1.0 - generator.nextDouble();
        return 1.0 / Math.pow(u, 1.0 / alpha);
    }
    public static double restrictValueToInterval(double x, double min, double max){
        return (x - min) / (max - min);
    }
}
