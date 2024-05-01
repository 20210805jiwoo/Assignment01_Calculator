package main.java.calculator;

public class DivideOperator {
    public double operate(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        return num1 / num2;
    }
}
