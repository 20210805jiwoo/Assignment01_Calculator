package main.java.calculator;

public class ArithmeticCalculator extends Calculator {
    // throws : 이 메서드가 어떤 예외사항 던질 수 있는 알려줌
    public double calculate(double num1, double num2, char operator) throws InvalidOperatorException, DivisionByZeroException {
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new DivisionByZeroException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new InvalidOperatorException("유효하지 않은 연산자 기호입니다.");
        }
        results.add(result);

        return result;
    }
}
