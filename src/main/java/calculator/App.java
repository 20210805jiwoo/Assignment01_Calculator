package main.java.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    //    Calculator calculator = new Calculator(); // Calculator 인스턴스 생성
        Calculator arithmeticCalculator = new ArithmeticCalculator();
        Calculator circleCalculator = new CircleCalculator();

        Scanner sc = new Scanner(System.in);

        System.out.println("1. 사칙연산 계산 ");
        System.out.println("2. 원의 넓이 계산");
        System.out.print("원하는 작업의 번호를 입력하세요: ");
        int choice = sc.nextInt();

        while (true) {
            switch (choice) {
                case 1: {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    int num1 = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int num2 = sc.nextInt();

                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char operator = sc.next().charAt(0);

                    try {
                        double result = arithmeticCalculator.calculate(num1, num2, operator);
                        System.out.println("결과: " + result);
                    } catch (InvalidOperatorException | DivisionByZeroException e) {
                        System.out.println("오류 발생: " + e.getMessage());
                    }

                    System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) ");
                    String removeInput = sc.next();
                    if (removeInput.equals("remove")) {
                        arithmeticCalculator.removeResult();
                    }

                    System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) ");
                    String inquiryInput = sc.next();
                    if (inquiryInput.equals("inquiry")) {
                        arithmeticCalculator.inquiryResults();
                    }
                }
                break;
                case 2: {
                    System.out.print("반지름을 입력하세요: ");
                    double radius = sc.nextDouble();
                    try {
                        double circleResult = circleCalculator.calculate(radius, 0, ' ');
                        System.out.println("결과: " + circleResult);
                        System.out.println("저장된 원의 넓이: " + circleCalculator.getResults());
                    } catch (InvalidOperatorException | DivisionByZeroException e) {
                        System.out.println("오류 발생: " + e.getMessage());
                    }
                }
                break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            String exitInput = sc.next();
            if (exitInput.equals("exit"))
                break;
        }
    }
}