package study.lotto.step2.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.step2.domain.AutoNumberSelector;
import study.lotto.step2.domain.Lotto;
import study.lotto.step2.domain.LottoFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LottoSellerTest {
    private static final int START_SEQUENCE_NUMBER = 1;
    private static final int END_SEQUENCE_NUMBER = 6;

    @Test
    @DisplayName("로또 장당 금액(1,000)보다 작은 금액으로 판매 시, IllegalArgumentException 예외 발생")
    void invalid_sell_amount() {
        // given
        int invalidAmount = 999;
        LottoSeller lottoSeller = new LottoSeller(sequenceLottoFactory());

        // when, then
        assertThatThrownBy(() -> lottoSeller.sell(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 구입 금액은 1000원입니다: " + invalidAmount);
    }

    @Test
    @DisplayName("로또 판매")
    void sell_lottos() {
        // given
        int amount = 4_999;
        LottoSeller lottoSeller = new LottoSeller(sequenceLottoFactory());

        // when
        List<Lotto> soldLottos = lottoSeller.sell(amount);

        // then
        assertThat(soldLottos).containsExactly(
                sequenceLotto(), sequenceLotto(), sequenceLotto(), sequenceLotto()
        );
    }

    private Lotto sequenceLotto() {
        return new Lotto(sequenceNumber());
    }

    private LottoFactory sequenceLottoFactory() {
        return new LottoFactory(sequenceNumberSelector());
    }

    private AutoNumberSelector sequenceNumberSelector() {
        return this::sequenceNumber;
    }

    private List<Integer> sequenceNumber() {
        return IntStream.rangeClosed(START_SEQUENCE_NUMBER, END_SEQUENCE_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}