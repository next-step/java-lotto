package controller.operation;

import domain.operations.StringCalculation;

import java.util.Scanner;

public class OperationView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열을 입력해주세요");
        String str = scanner.nextLine();
        int sum = StringCalculation.getSum(str);
        System.out.println(sum);

    }
}
