package main.java.calculator;

public class CircleCalculator extends Calculator {
    public double calculate(double radius, double diameter, char operator) {
        if (radius <= 0) {
            throw new IllegalArgumentException("반지름은 0보다 커야 합니다.");
        } else {
            double circleArea = Math.PI * radius * radius;
            results.add(circleArea);
            return circleArea;
        }
    }
}