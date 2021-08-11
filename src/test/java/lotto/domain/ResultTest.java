package lotto.domain;

import lotto.generic.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @DisplayName("로또 등수 count 찾기")
    @Test
    void findCount_ReturnLottoStatusCount_AccordingToLottoStatus() {
        Result result = new Result();
        int repeatCount = 4;
        LottoStatus lottoStatus = LottoStatus.FIRST;
        repeatReport(result, lottoStatus, repeatCount);
        assertThat(result.findCount(lottoStatus)).isEqualTo(repeatCount);
    }

    @DisplayName("수익율 계산")
    @Test
    void calculateRatio() {
        Result result = new Result();
        Money winningAmountSum = Money.ZERO;
        int ticketCount = 3;

        LottoStatus lottoStatus = LottoStatus.FIRST;
        result.report(lottoStatus);
        winningAmountSum = winningAmountSum.plus(lottoStatus.getWinningAmount());

        lottoStatus = LottoStatus.THIRD;
        result.report(lottoStatus);
        winningAmountSum = winningAmountSum.plus(lottoStatus.getWinningAmount());

        lottoStatus = LottoStatus.FOURTH;
        result.report(lottoStatus);
        winningAmountSum = winningAmountSum.plus(lottoStatus.getWinningAmount());

        Money purchaseAmount = LottoGame.LOTTO_PRICE.times(ticketCount);
        double expected = winningAmountSum.divide(purchaseAmount);

        assertThat(result.calculateRatio()).isEqualTo(expected);
    }

    private void repeatReport(Result result, LottoStatus lottoStatus, int repeatCount) {
        IntStream.range(0, repeatCount)
                .forEach((index) -> result.report(lottoStatus));
    }
}
