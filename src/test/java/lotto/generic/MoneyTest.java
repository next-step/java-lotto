package lotto.generic;

import lotto.domain.LottoStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @DisplayName("더하기")
    @Test
    void plus() {
        Money money = Money.wons(1000L);
        Money plus = money.plus(Money.wons(2000L));
        assertThat(plus).isEqualTo(Money.wons(3000L));
    }

    @DisplayName("나누기")
    @Test
    void divide() {
        Money money = Money.wons(14500);
        int ticketCount = money.divideAndDiscardRemainder(Money.wons(1000L));
        assertThat(ticketCount).isEqualTo(14500 / 1000);
    }

    @DisplayName("합계")
    @Test
    void sum() {
        List<LottoStatus> lottoStatuses = Arrays.stream(LottoStatus.values()).collect(Collectors.toList());
        Money expected = lottoStatuses.stream()
                .map(LottoStatus::getWinningAmount)
                .reduce(Money.ZERO, Money::plus);
        Money winningMoneySum = Money.sum(lottoStatuses, LottoStatus::getWinningAmount);
        assertThat(winningMoneySum).isEqualTo(expected);
    }
}
