package com.example.calculator2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //객체 생성
        Calculator cal = new Calculator();//Calculator 클래스의 객체인 cal 인스턴스 생성

        Scanner sc = new Scanner(System.in);

        //값 입력받기
        while (true) {//무한반복

            //첫번째 숫자 입력 받기 ================
            int num1 = 0;
            while (true) {
                System.out.print("첫 번째 양의 정수를 입력해주세요 : ");

                //양의 정수만 입력받고 싶음
                if (sc.hasNextInt()) {//hasNextInt : Scanner 객체에 입력된 값이 int값일 때 true 반환
                    num1 = sc.nextInt();
                    if (num1 >= 0) {//0보다 크거나 같은 수만 입력 가능
                        break;//while문 종료
                    } else {
                        System.out.println("잘못된 입력입니다. 양의 정수(0 포함)를 입력해주세요.");
                    }//if-else(inner)
                } else {
                    System.out.println("잘못된 입력입니다. 양의 정수(0 포함)를 입력해주세요.");
                    sc.nextLine();//잘못 입력됐을 시 처리
                }//if-else(outer)
            }//while(inner)
            sc.nextLine();//개행문자 \n 읽는 용도

            //사칙연산 기호 입력받기 ================
            String operator;
            char operatorChar;
            while (true) {
                System.out.print("사칙연산 기호를 입력하세요 : ");

                operator = sc.next();//0번 인덱스 한글자만 가져옴
                //하나의 사칙연산만 입력 받고 싶음
                if (operator.equals("+")
                        || operator.equals("-")
                        || operator.equals("*")
                        || operator.equals("/")) {// operator 변수의 값이 사칙연산 기호일 경우 true

                    operatorChar = operator.charAt(0);//입력받은 문자를 넣기
                    break;//while문 종료

                } else {
                    System.out.println("잘못된 입력입니다. 사칙연산 기호를 입력하세요");
                    sc.nextLine();//잘못 입력됐을 시 처리
                }//if-else
            }//while(inner)

            //두번째 값 입력 받기 ================
            int num2 = 0;
            while (true) {
                System.out.print("두 번째 양의 정수를 입력해주세요 : ");

                //양의 정수만 입력받고 싶음
                if (sc.hasNextInt()) {//hasNextInt : Scanner 객체에 입력된 값이 int값일 때 true 반환
                    num2 = sc.nextInt();

                    //입력받은 사칙연산이 나눗셈이면서 숫자 0일 경우
                    if (operatorChar == '/' && num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        continue;//다시 num2 입력 진행
                    }//if

                    if (num2 >= 0) {//0보다 크거나 같은 수만 입력 가능
                        break;//while문 종료
                    } else {
                        System.out.println("잘못된 입력입니다. 양의 정수(0 포함)를 입력해주세요.");
                        sc.nextLine();//잘못 입력됐을 시 처리
                    }//if-else(inner)
                } else {
                    System.out.println("잘못된 입력입니다. 양의 정수(0 포함)를 입력해주세요.");
                    sc.nextLine();//잘못 입력됐을 시 처리
                }//if-else(outer)
            }//while(inner)
            sc.nextLine();//개행문자 \n 읽는 용도

            //계산 결과 조회=============
            //결과값 가져오기
            cal.calculate(num1, operatorChar, num2);
            System.out.println("저장된 데이터를 조회하시겠습니까? (y 입력 시 전체 list 조회)");
            if (sc.nextLine().equals("y")) {
                System.out.println("삭제 후 list : " + cal.getResultList());
            }//if

            //연산 결과 삭제여부 =============
            System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제) 아니면 n 키를 입력주세요.");
            if (sc.nextLine().equals("remove")) {
                cal.RemoveResult();//삭제 메서드
                System.out.println("데이터가 삭제되었습니다.");
                System.out.println("삭제 후 list : " + cal.getResultList());
            }//if

            //계산 진행여부 =============
            System.out.println("더 계산하시겠습니까? enter 키를 눌러주세요. (exit 입력 시 종료)");
            String exit = sc.nextLine();

            //계산 종료 ===========
            if (exit.equals("exit")) {
                System.out.println("계산을 종료합니다.");
                break;//while문 종료
            }//if


        }//while

    }//main
}//end class
