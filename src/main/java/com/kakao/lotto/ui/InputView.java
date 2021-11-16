package com.kakao.lotto.ui;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private final InputStream inputStream;

    public InputView(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int inputLottoPerchase() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(inputStream).nextInt();
    }

    public String inputCorrectLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(inputStream).nextLine();
    }
}
