package main.java.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다.
        int[] arr = new int[10];

        // 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언
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
                System.out.println("기호를 잘못 입력했습니다.");
                continue;
            }

            // 연산의 결과를 배열에 저장
            if(lastIndex < arr.length) { // 배열 크기 초과하지 않는 경우
                arr[lastIndex] = result;
                lastIndex++; // index 증가
            } else { // 배열 크기 초과하면, 가장 먼저 저장된 결과 삭제하고 새로운 결과 저장
                for (int i = 0; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1]; // 결과들을 한 칸씩 앞으로 이동
                }
                arr[arr.length - 1] = result; // 새로운 결과 배열 마지막에 저장
            }

            System.out.println("결과: " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if (exit.equals("exit"))
                break;
        }

        // 배열에 저장된 연산 결과 출력
        System.out.println("저장된 연산 결과: ");
        for (int i = 0; i < lastIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
