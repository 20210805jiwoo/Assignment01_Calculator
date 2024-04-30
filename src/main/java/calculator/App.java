package main.java.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<Integer>(); // 컬렉션 타입 변수 선언 및 생성

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, /
            /* charAt(idx) : charAt 메서드는 매개변수로 char 타입으로 변환하고자하는 문자열 위치 받는다*/
            char operator = sc.next().charAt(0);

            int result = 0;

            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                    continue;
                }
            } else {
                System.out.println("기호를 잘못 입력했습니다.");
                continue;
            }

            System.out.println("결과: " + result);

            // remove 입력 시 가장 먼저 저장된 결과 삭제
            System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String removeInput = sc.next();
            if (removeInput.equals("remove")) {
                numbers.remove(0); // ArrayList의 첫 번째 요소 삭제
                System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
            }

            // 연산 결과 ArrayList에 추가
            numbers.add(result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if (exit.equals("exit"))
                break;
        }

        // 배열에 저장된 연산 결과 출력
        System.out.println("저장된 연산 결과: ");
        for(Integer num : numbers) {
            System.out.print(num + " ");
        }
    }
}
