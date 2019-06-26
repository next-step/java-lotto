package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.LowMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoStoreTest {

    @DisplayName("자동 구매 테스트")
    @Test
    void should_return_buyAutoLottos_when_buyAutoByRemainingMoney() {
        // given
        final int countOfLotto = 10;
        final Money money = new Money(countOfLotto * Lotto.PRICE_VALUE);

        // when
        final List<Lotto> lottos = LottoStore.buyAutoByRemainingMoney(money);

        // then
        assertThat(lottos).hasSize(countOfLotto);
    }


    @DisplayName("수동 구매 테스트")
    @Test
    void should_return_buyManualLottos_when_buyManual() {
        final List<String> lottoNumbers = List.of(
                "1,2,3,4,5,6",
                "2,3,4,5,6,7",
                "3,4,5,6,7,8"
        );
        final LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        final Money money = new Money(lottoNumbers.size() * Lotto.PRICE_VALUE);

        final List<Lotto> lottos = LottoStore.buyManual(money, lottoTicket);

        assertThat(lottos).hasSameSizeAs(lottoNumbers);
        assertThat(lottoTicket.getLottos()).containsAll(lottos);
    }

    @DisplayName("수동 구매 시 잔액 부족 예외처리")
    @Test
    void should_return_LowMoneyException_when_buyManual() {
        final List<String> lottoNumbers = List.of(
                "1,2,3,4,5,6",
                "2,3,4,5,6,7",
                "3,4,5,6,7,8"
        );
        final LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        final Money money = new Money(0);

        assertThatExceptionOfType(LowMoneyException.class)
                .isThrownBy(() -> {
                    LottoStore.buyManual(money, lottoTicket);
                });
    }

    @DisplayName("로또 게임 자동 구매 갯수 확인")
    @ParameterizedTest
    @ValueSource(ints = {
            1,
            10,
            300,
            400
    })
    void should_equals_lottoCount_when_buyAutoByRemainingMoney(final int buyCount) {
        // given
        final Money money = new Money(Lotto.PRICE_VALUE * buyCount);

        // when
        final List<Lotto> lottos = LottoStore.buyAutoByRemainingMoney(money);

        // then
        assertThat(lottos).hasSize(buyCount);
    }
}
