package lotto.view;

import lotto.domain.LottoNumber;

public class ResultView {
    private static String COUNT_OF_LOTTO_QUESTION = "개를 구입했습니다.";

    public static void countOfLotto(int lottoCount) {
        System.out.println(lottoCount + COUNT_OF_LOTTO_QUESTION);
    }

    public static void printLottoNumber(LottoNumber lottoNumber) {
        System.out.println(lottoNumber.value());
    }
}
