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

        int countOfTicket = lottoResultDto.getCountOfTicket();
        Money spendMoney = LOTTO_TICKET_PRICE.times(countOfTicket);
        Money earnMoney = Money.ZERO;
        for (Reward reward : Reward.getReportableRewards()) {
            earnMoney = earnMoney.plus(getWinningAmount(reward, lottoResultDto));
            print(reward, lottoResultDto);
        }

        printReportEarningsRate(spendMoney, earnMoney);
    }

    private void printReportHeader() {
        System.out.print(REPORT_HEADER_TEXT);
    }

    private void printReportEarningsRate(Money spendMoney, Money earnMoney) {
        float rate = spendMoney.amount.divide(earnMoney.amount, BigDecimal.ROUND_UP).floatValue();
        String earnText = rate > 1.0f ? PROFIT_TEXT : LOSS_TEXT;
        System.out.printf(EARN_RATE_FORMAT_TEXT, rate, earnText);
    }

    private Money getWinningAmount(Reward reward, LottoResultDto lottoResultDto) {
        int countByMatchCount = lottoResultDto.getCountByMatchCount(reward.getCountOfMatch());
        return reward.getWinningMoney().times(countByMatchCount);
    }

    private void print(Reward reward, LottoResultDto lottoResultDto) {
        int countOfMatch = reward.getCountOfMatch();
        int countByMatchCount = lottoResultDto.getCountByMatchCount(countOfMatch);
        Money winningMoney = reward.getWinningMoney();

        String message = String.format(NUMBER_MATCHING_FORMAT_TEXT,
                countOfMatch, winningMoney.getAmountLongValue(), countByMatchCount);

        System.out.println(message);
    }
}
