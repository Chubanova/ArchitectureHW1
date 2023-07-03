package com.chubanova;

public class QuadraticEquationSolver {

    public double[] solve(double a, double b, double c, double e) {
        if (Math.abs(a) < e) {
            throw new RuntimeException("Необходимо задать а отличное от нуля");
        }

        if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c) || Double.isNaN(e)) {
            throw new RuntimeException("Необходимо задать коэффициенты отличное от NaN");
        }

        double[] result;

        double d = b * b - 4 * a * c;

        if (d > e) {
            double x1 = (-b - Math.sqrt(d)) / (2 * a);
            double x2 = (-b + Math.sqrt(d)) / (2 * a);
            result = new double[]{x1, x2};
        } else if (Math.abs(d) <= e) {
            double x = -b / (2 * a);
            result = new double[]{x, x};
        } else {
            result = new double[]{};
        }

        return result;
    }

}
