package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAuto {

    private static final int LOTTO_PRICE = 1000;
    private static final List<List<Integer>> lottoList = new ArrayList<>();
    private static int totalLottoCount;
    private static int amount;

    public static void input() {
        amount = InputView.inputBuyAmount();
    }

    static void buyAuto(int amount) {
        totalLottoCount = amount / LOTTO_PRICE;
        ResultView.printBuyCompleted(String.valueOf(totalLottoCount));
    }

    static List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    static void addLotto(int totalLottoCount) {
        for (int count = 0; count < totalLottoCount; count++) {
            lottoList.add(createLottoNumbers());
        }
        ResultView.printLottoList(lottoList);
    }

}
