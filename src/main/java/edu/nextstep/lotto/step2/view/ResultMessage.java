package edu.nextstep.lotto.step2.view;

import edu.nextstep.lotto.step2.domain.LottoList;
import edu.nextstep.lotto.step2.domain.WinningAmount;
import edu.nextstep.lotto.step2.domain.WinningList;

public class ResultMessage {
    public static final String MESSAGE_NUMBER_OF_PURCHASE = "%s 개를 구매했습니다.%n";
    public static final String MESSAGE_STATISTICS = "%s개 일치 (%s원)- %s개%n";
    public static final String MESSAGE_RATE = "총 수익률은 %.2f 입니다.";
    public static final String MESSAGE_RATE_ETC = " (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static String getStatisticsMessage(LottoList lottoList, WinningList winningList, WinningAmount winningAmount) {
        return String.format(MESSAGE_STATISTICS, winningAmount.getCount(), winningAmount.getAmount(), lottoList.getMatchResult(winningList, winningAmount.getCount()));
    }
}
