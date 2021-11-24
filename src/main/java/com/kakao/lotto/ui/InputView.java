package com.kakao.lotto.ui;

import java.io.InputStream;
import java.util.ArrayList;
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

    public int inputLottoPrice() {
        System.out.println("\n구입금액을 입력해 주세요.");
        return new Scanner(inputStream).nextInt();
    }

    public List<List<Integer>> inputPickedLotteries() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int pickedCount = new Scanner(inputStream).nextInt();

        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> inputLotteries = new ArrayList<>(pickedCount);
        for (int i = 0; i < pickedCount; i++) {
            String pickedLotto = new Scanner(inputStream).nextLine();
            inputLotteries.add(makeIntegerList(pickedLotto));
        }
        return inputLotteries;
    }


    public List<Integer> inputWinLotto() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String winLotto = new Scanner(inputStream).nextLine();
        return makeIntegerList(winLotto);
    }

    public int inputLottoBonus() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return new Scanner(inputStream).nextInt();
    }

    private List<Integer> makeIntegerList(String line) {
        return Arrays.stream(line.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
