package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printLotteryCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLotteries(final List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }
}
