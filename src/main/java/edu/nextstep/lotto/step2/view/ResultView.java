package edu.nextstep.lotto.step2.view;

import edu.nextstep.lotto.step2.domain.LottoList;
import edu.nextstep.lotto.step2.domain.WinningAmount;
import edu.nextstep.lotto.step2.domain.WinningList;

import java.util.Arrays;
import java.util.Comparator;

import static edu.nextstep.lotto.step2.domain.WinningAmount.values;

public class ResultView {

    private static final String NEW_LINE = "\n";

    public void outputNumberOfPurchase(LottoList lottoList) {
        System.out.printf(ViewMessage.Result.NUMBER_OF_PURCHASE, lottoList.getLottoList().size());
    }

    public void outputLottoList(LottoList lottoList) {
        lottoList.getLottoList().forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
        System.out.print(NEW_LINE);
    }

    public void outputStatistics(LottoList lottoList, WinningList winningList) {
        Arrays.stream(values())
                .sorted(Comparator.comparing(WinningAmount::getCount))
                .forEach(amount -> System.out.print(ViewMessage.getStatisticsMessage(lottoList, winningList, amount)));
    }

    public void outputRate(LottoList lottoList, WinningList winningList, int purchaseAmount) {
        float rate = lottoList.getRate(winningList, purchaseAmount);

        System.out.printf(ViewMessage.Result.RATE, rate);

        if (rate < 1) {
            System.out.print(ViewMessage.Result.RATE_ETC);
        }
    }
}
