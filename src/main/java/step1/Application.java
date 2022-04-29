package step1;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산기에 입력하세요");
        Caculater caculater = new Caculater(scanner.nextLine());

        System.out.println("결과 값 : " + caculater.result());
    }
}
