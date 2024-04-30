package main.java.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다. */
        int[] arr = new int[10];

        /* 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언 */
        int lastIndex = 0;

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
                System.out.println("기호를 잚못 입력했습니다.");
                continue;
            }

            /* 연산의 결과를 배열에 저장 */
            arr[lastIndex] = result;
            lastIndex++;

            System.out.println("결과: " + result);

            System.out.print("프로그램을 종료하려면 exit을 입력하세요: ");
            String exit = sc.next();
            if (exit.equals("exit"))
                break;
        }

        /* 배열에 저장된 연산 결과 출력 */
        System.out.println("저장된 연산 결과: ");
        for (int i = 0; i < lastIndex; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
