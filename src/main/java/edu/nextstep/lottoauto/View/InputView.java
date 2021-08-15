/*
 * InputView.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.View;

import java.util.Scanner;

public class InputView {

    public static int inputPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    };
}
