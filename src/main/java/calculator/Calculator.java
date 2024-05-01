package main.java.calculator;

import java.util.ArrayList;
import java.util.List;

// 연산자 기호 잘못된 경우 처리
class InvalidOperatorException extends Exception {
    public InvalidOperatorException(String message) {
        super(message);
    }
}

// 나눗셈에서 분모 0인 경우 처리
class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

public abstract class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드가 생성자를 통해 초기화 되도록 변경 */
    protected List<Double> results;

    public Calculator() {
        this.results = new ArrayList<>();
    }

    /* static, final 활용 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성 */
    private static final List<Double> circleAreas = new ArrayList<>();

    public abstract double calculate(double num1, double num2, char operator) throws InvalidOperatorException, DivisionByZeroException;

    // Getter 메서드
    public List<Double> getResults() {
        return results;
    }

    public static List<Double> getCircleAreas() {
        return circleAreas;
    }

    // Setter 메서드
    public void setResults(List<Double> results) {
        this.results = results;
    }

    // 가장 먼저 저장된 데이터 삭제하는 메서드
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }

    public void inquiryResults() {
        System.out.println("저장된 연산 결과: " + results);
    }
}