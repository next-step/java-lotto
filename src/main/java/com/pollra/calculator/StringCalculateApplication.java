package com.pollra.calculator;

import java.util.Scanner;

/**
 * @since       2021.11.29
 * @author      pollra
 **********************************************************************************************************************/
class StringCalculateApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("합산할 값을 입력해 주세요"
                +"(기본 구분자[\",\", \":\"])\n"
                +"(커스텀구분자는 \"//i\\\\n\" 에서 i 위치에 들어갑니다)"
        );
        String inputText = scanner.nextLine();

        Calculator calculator = new Calculator();
        Number sumResult = calculator.sum(inputText);
        System.out.println("결과: " + sumResult.getValue());
    }
}
