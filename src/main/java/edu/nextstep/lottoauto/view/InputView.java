package edu.nextstep.lottoauto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String inputWinningNumbers() {
        Scanner scanner2 = new Scanner(System.in); // 전역 변수 지정한 Scanner 로 실행 시 입력 없이 지나가버림..
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
        return scanner2.nextLine();
    }

}
