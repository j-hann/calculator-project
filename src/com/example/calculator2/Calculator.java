package com.example.calculator2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
//연산 수행 역할 클래스

    //App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)
    //연산 결과 저장 - 선언, 생성 > Queue는 가장 먼저 들어간 값을 가장 먼저 조회 가능함
    private Queue<Double> resultList = new LinkedList<Double>();
    private double result = 0; //결과 선언, 초기화

    //Getter 메서드 구현 -> 내보내야하는 정보만 보낼 수 있음
    public Queue<Double> getResultList() { //resultList를 반환하는 getter 메소드
        return resultList;//저장된 결과값
    }//getResultList

    public double calculate(int num1, char operatorChar, int num2) {//매개변수

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
                double divide = (double) num1 / num2;//형변환
                result = divide;
                System.out.println("결과 : " + result);
                break;
        }//switch

        //resultList 변수에 결과값 저장하기
        resultList.add(result);
        return result;
    }//calculate

    //Setter 메서드 구현 -> 저장, 수정할 필요가 있을때 사용
    //쓰기 어려움..
//    public void setResultList(Queue<Double> resultList) {
//        this.resultList = resultList;
//    }//setResultList

    //Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현
    public void RemoveResult() {
        //삭제 메서드
        resultList.poll();//꺼내기
    }//setResultList

}//end class

