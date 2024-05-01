package main.java.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(); // Calculator 인스턴스 생성

        Scanner sc = new Scanner(System.in);

        /* 반복문 시작 */
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            try {
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (InvalidOperatorException | DivisionByZeroException e) {
                System.out.println("오류 발생: " + e.getMessage());
            }

            System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) ");
            String removeInput = sc.next();
            if (removeInput.equals("remove")) {
                calculator.removeResult();
            }

            System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) ");
            String inquiryInput = sc.next();
            if (inquiryInput.equals("inquiry")) {
                calculator.inquiryResults();
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            String exitInput = sc.next();
            if (exitInput.equals("exit"))
                break;
        }
    }
}