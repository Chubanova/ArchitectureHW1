package com.chubanova;

import org.junit.Before;
import org.junit.Test;

import static java.lang.Double.NaN;
import static org.junit.Assert.assertArrayEquals;

public class QuadraticEquationSolverTest {

    private final double e = 10e-15;

    private QuadraticEquationSolver solver;

    @Before
    public void init() {
        solver = new QuadraticEquationSolver();
    }

    // Написать тест, который проверяет, что для уравнения x^2+1 = 0 корней нет (возвращается пустой массив)
    @Test
    public void solve_no_result() {
        double[] result = solver.solve(1, 0, 1, e);
        assertArrayEquals(new double[]{}, result, e);
    }

    // Написать тест, который проверяет, что для уравнения x^2-1 = 0 есть два корня кратности 1 (x1=1, x2=-1)
    @Test
    public void solve_two_result() {
        double[] result = solver.solve(1, 0, -1, e);
        assertArrayEquals(new double[]{-1, 1}, result, e);
    }

    // Написать тест, который проверяет, что для уравнения x^2+2x+1 = 0 есть один корень кратности 2 (x1= x2 = -1).
    @Test
    public void solve_one_result() {
        double[] result = solver.solve(1, 2, 1, e);
        assertArrayEquals(new double[]{-1, -1}, result, e);
    }

    // Написать тест, который проверяет, что коэффициент a не может быть равен 0. В этом случае solve выбрасывает исключение.
    @Test(expected = RuntimeException.class)
    public void solve_exception() {
        solver.solve(0.0, 2, 1, e);
    }

    // С учетом того, что дискриминант тоже нельзя сравнивать с 0 через знак равенства, подобрать такие коэффициенты квадратного уравнения для случая одного корня кратности два,
    // чтобы дискриминант был отличный от нуля, но меньше заданного эпсилон. Эти коэффициенты должны заменить коэффициенты в тесте из п. 7.
    @Test
    public void solve_two_result_nano() {
        double e = 0.0001;
        double[] result = solver.solve(1, 0.01, 0.000001, e);
        assertArrayEquals(new double[]{-0.005, -0.005}, result, e);
    }

    // Посмотреть какие еще значения могут принимать числа типа double, кроме числовых и написать тест с их использованием на все коэффициенты. solve должен выбрасывать исключение.
    @Test(expected = RuntimeException.class)
    public void solve_exception2() {
        solver.solve(NaN, NaN, NaN, NaN);
    }

}