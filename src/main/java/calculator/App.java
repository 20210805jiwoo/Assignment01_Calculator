package main.java.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AddOperator addOperator = new AddOperator();
        SubtractOperator subtractOperator = new SubtractOperator();
        MultiplyOperator multiplyOperator = new MultiplyOperator();
        DivideOperator divideOperator = new DivideOperator();
        ModOperator modOperator = new ModOperator();

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(addOperator, subtractOperator, multiplyOperator, divideOperator, modOperator);
        CircleCalculator circleCalculator = new CircleCalculator();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 사칙연산 계산 ");
            System.out.println("2. 원의 넓이 계산");
            System.out.print("원하는 작업의 번호를 입력하세요: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    int num1 = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int num2 = sc.nextInt();

                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char operator = sc.next().charAt(0);

                    double result = arithmeticCalculator.calculate(num1, num2, operator);
                    System.out.println("결과: " + result);

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
                    int radius = sc.nextInt();
                    double circleResult = circleCalculator.calculate(radius, 0, ' ');
                    System.out.println("결과: " + circleResult);
                    System.out.println("저장된 원의 넓이: " + circleCalculator.getResults());
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