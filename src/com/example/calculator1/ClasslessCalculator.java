package com.example.calculator1;

import java.util.Scanner;

public class ClasslessCalculator {
    //클래스 없는 계산기
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //연산하기
        while (true) {//무한반복

            //첫번째 숫자 입력 받기 ================
            int num1 = 0;
            while (true){
                System.out.print("첫 번째 양의 정수를 입력해주세요 : ");

                //양의 정수만 입력받고 싶음
                if (sc.hasNextInt()){//hasNextInt : Scanner 객체에 입력된 값이 int값일 때 true 반환
                    num1 = sc.nextInt();
                    if (num1 >= 0) {//0보다 크거나 같은 수만 입력 가능
                        break;//while문 종료
                    }else {
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
            while (true){
                System.out.print("사칙연산 기호를 입력하세요 : ");

                operator = sc.next();//0번 인덱스 한글자만 가져옴
                //하나의 사칙연산만 입력 받고 싶음
                if (operator.equals("+")
                    || operator.equals("-")
                    || operator.equals("*")
                    || operator.equals("/")){// operator 변수의 값이 사칙연산 기호일 경우 true

                    //chatAt 메소드는 char배열에서 index번호의 값을 반환하는 간단한 로직이다
                    //다만 인덱스가 기준문자열의 마지막 인덱스 번호보다 크거나 음수가 들어가면 예외가 발생한다
                    operatorChar = operator.charAt(0);//입력받은 문자를 넣기
                    break;//while문 종료

                } else {
                    System.out.println("잘못된 입력입니다. 사칙연산 기호를 입력하세요");
                    sc.nextLine();//잘못 입력됐을 시 처리
                }//if-else
            }//while(inner)


            //두번째 값 입력 받기 ================
            int num2 = 0;
            while (true){
                System.out.print("두 번째 양의 정수를 입력해주세요 : ");

                //양의 정수만 입력받고 싶음
                if (sc.hasNextInt()){//hasNextInt : Scanner 객체에 입력된 값이 int값일 때 true 반환
                    num2 = sc.nextInt();

                    //입력받은 사칙연산이 나눗셈이면서 숫자 0일 경우
                    if (operatorChar == '/' && num2 == 0){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        continue;//다시 num2 입력 진행
                    }//if
                    
                    if (num2 >= 0) {//0보다 크거나 같은 수만 입력 가능
                        break;//while문 종료
                    }else {
                        System.out.println("잘못된 입력입니다. 양의 정수(0 포함)를 입력해주세요.");
                        sc.nextLine();//잘못 입력됐을 시 처리
                    }//if-else(inner)
                } else {
                    System.out.println("잘못된 입력입니다. 양의 정수(0 포함)를 입력해주세요.");
                    sc.nextLine();//잘못 입력됐을 시 처리
                }//if-else(outer)
            }//while(inner)
            sc.nextLine();//개행문자 \n 읽는 용도


            double result = 0; //결과 선언, 초기화

            //연산 ================
            switch (operatorChar) {
                case '+'://더하기
                    int sum = num1 + num2;
                    result = sum;
                    System.out.println("결과 : " + result);
                    break;
                case '-'://빼기
                    int subtract = num1 - num2;
                    result = subtract;
                    System.out.println("결과 : " + result);
                    break;
                case '*'://곱하기
                    int multiply = num1 * num2;
                    result = multiply;
                    System.out.println("결과 : " + result);
                    break;
                case '/'://나누기
                    double divide = (double)num1 / num2;//형변환
                    result = divide;
                    System.out.println("결과 : " + result);
                    break;
                default: // 조건식의 결과 값이 위의 어떤 값에도 해당하지 않을 때 실행되는 코드
//                    System.out.println("잘못된 기호입니다. 다시 입력해주세요.");
            }//switch

            //결과 =============
            System.out.println("더 계산하시겠습니까? enter 키를 눌러주세요. (exit 입력 시 종료)");
            String exit = sc.nextLine();

            //계산 종료 ===========
            if (exit.equals("exit")) {
                System.out.println("계산을 종료합니다.");
                break;//while문 종료
            }//if
        }//while(outer)


    }//main
}//end class
