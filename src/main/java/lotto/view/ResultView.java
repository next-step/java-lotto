package lotto.view;

import lotto.domain.Lotto;

public class ResultView {
    public static void resultLottoNumber(int lottoOfNumber, Lotto lotto) {
        String[] temporary = lotto.toString().substring(1, lotto.toString().length() - 2).split("], ");

        System.out.println(lottoOfNumber + "개를 구매하였습니다.");
        for (int i = 0; i < lottoOfNumber; i++) {

            System.out.println(temporary[i] + "]");
        }

    }

    public static void resultStatus() {

    }
}
