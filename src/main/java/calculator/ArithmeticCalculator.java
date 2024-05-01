package main.java.calculator;

public class ArithmeticCalculator extends Calculator {
    private AddOperator addOperator;
    private SubtractOperator subtractOperator;
    private MultiplyOperator multiplyOperator;
    private DivideOperator divideOperator;

    public ArithmeticCalculator(AddOperator addOperator, SubtractOperator subtractOperator, MultiplyOperator multiplyOperator, DivideOperator divideOperator) {
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
    }

    // throws : 이 메서드가 어떤 예외사항 던질 수 있는 알려줌
    public double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return addOperator.operate(num1, num2);
            case '-':
                return subtractOperator.operate(num1, num2);
            case '*':
                return multiplyOperator.operate(num1, num2);
            case '/':
                return divideOperator.operate(num1, num2);
            default:
                throw new IllegalArgumentException("올바르지 않은 연산자입니다.");
        }
    }
}
