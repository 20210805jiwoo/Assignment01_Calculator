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

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 (외부에서 접근 못함) */
    private List<Integer> results = new ArrayList<>();

    // throws : 이 메서드가 어떤 예외사항 던질 수 있는 알려줌
    public int calculate(int num1, int num2, char operator) throws InvalidOperatorException, DivisionByZeroException {
        int result = 0;
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

    // Getter 메서드
    public List<Integer> getResults() {
        return results;
    }

    // Setter 메서드
    public void setResults(List<Integer> results) {
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
