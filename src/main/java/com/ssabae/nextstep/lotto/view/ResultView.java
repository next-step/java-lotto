package com.ssabae.nextstep.lotto.view;

import static com.ssabae.nextstep.lotto.Constant.LOTTO_TICKET_PRICE;

import com.ssabae.nextstep.lotto.application.LottoResultDto;
import com.ssabae.nextstep.lotto.domain.Money;
import com.ssabae.nextstep.lotto.domain.Reward;
import java.math.BigDecimal;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class ResultView {

    private static final String NUMBER_MATCHING_FORMAT_TEXT = "%d개 일치 (%d원)- %d개";
    private static final String EARN_RATE_FORMAT_TEXT = "총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)\n";
    private static final String REPORT_HEADER_TEXT = "당첨 통계\n---------\n";
    private static final String PROFIT_TEXT = "이익이";
    private static final String LOSS_TEXT = "손해";

    public void report(LottoResultDto lottoResultDto) {
        printReportHeader();
        for (Reward reward : Reward.getReportableRewards()) {
            print(reward, lottoResultDto);
        }
        printReportEarningsRate(lottoResultDto);
    }

    private void printReportHeader() {
        System.out.print(REPORT_HEADER_TEXT);
    }

    private void printReportEarningsRate(LottoResultDto lottoResultDto) {
        float rate = lottoResultDto.getEarnRate();
        String earnText = rate > 1.0f ? PROFIT_TEXT : LOSS_TEXT;
        System.out.printf(EARN_RATE_FORMAT_TEXT, rate, earnText);
    }


    private void print(Reward reward, LottoResultDto lottoResultDto) {
        Money winningMoney = reward.getWinningMoney();
        int countByMatchCount = lottoResultDto.getCountByMatchCount(reward.getCountOfMatch());
        String message = String.format(NUMBER_MATCHING_FORMAT_TEXT,
                countByMatchCount,
                winningMoney.getAmountLongValue(),
                countByMatchCount);

        System.out.println(message);
    }
}
