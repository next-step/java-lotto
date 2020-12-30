package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMoney;

import java.util.List;

public class ResultView {

    public static void printCoinAndRemainMoney(LottoMoney lottoMoney) {
        System.out.printf("%d개를 구매했습니다. 거스름돈은 %d원 입니다.%n",lottoMoney.getCoin(),lottoMoney.getRemainMoney());
    }

    public static void printBuyLottoNumber(List<Lotto> buyLotto) {
        System.out.println(buyLotto.toString());
    }
}
