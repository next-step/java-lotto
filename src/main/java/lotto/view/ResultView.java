package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {

    private static String RESULT_MESSAGE = "개를 구매했습니다.";

    public ResultView() {}

    public void resultOfBuyLotto(String result) {
        System.out.println(result + RESULT_MESSAGE);
    }

    public void resultOfLottoList(List<Lotto> lottos) {

        for(Lotto lotto : lottos) {
            System.out.print("[");

            System.out.print("여기에 로또 번호 노출되도록 추가");

            System.out.println("]");
        }
    }
}
