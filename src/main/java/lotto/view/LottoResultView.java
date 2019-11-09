package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 23:10
 */
public class LottoResultView {

    public static void printPurchasedLotto(List<Lotto> lottos) {
        lottos.stream().map(Lotto::getLottoNumber).forEach(System.out::println);
    }

    public static void printLottoPurchaseCount(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
    }
}
