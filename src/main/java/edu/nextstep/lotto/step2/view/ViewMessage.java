package edu.nextstep.lotto.step2.view;

import edu.nextstep.lotto.step2.domain.LottoList;
import edu.nextstep.lotto.step2.domain.WinningAmount;
import edu.nextstep.lotto.step2.domain.WinningList;

public class ViewMessage {

    public static class Input {
        public static final String QUESTION_PURCHASE_AMOUNT = "구입 금액을 입력해주세요.";
        public static final String QUESTION_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해주세요.";
    }

    public static class Result {
        public static final String NUMBER_OF_PURCHASE = "%s 개를 구매했습니다.%n";
        public static final String STATISTICS = "%s개 일치 (%s원)- %s개%n";
        public static final String RATE = "총 수익률은 %.2f 입니다.";
        public static final String RATE_ETC = " (기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }

    public static String getStatisticsMessage(LottoList lottoList, WinningList winningList, WinningAmount winningAmount) {
        return String.format(Result.STATISTICS, winningAmount.getCount(), winningAmount.getAmount(), lottoList.getMatchResult(winningList, winningAmount.getCount()));
    }
}
