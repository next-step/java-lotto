package com.kakao.lotto.ui;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";

    private final InputStream inputStream;

    public InputView(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int inputLottoPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(inputStream).nextInt();
    }

    public List<Integer> inputWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winLotto = new Scanner(inputStream).nextLine();
        return makeIntegerList(winLotto);
    }

    private List<Integer> makeIntegerList(String line){
        return Arrays.stream(line.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
