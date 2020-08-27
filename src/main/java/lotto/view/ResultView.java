package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    public static void printLottoCount(int lottoPrice) {
        System.out.println(lottoPrice+"개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> System.out.println(lotto.getLotto()));
    }
}
