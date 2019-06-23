package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.InvalidCountOfLottoNumberException;
import com.jaeyeonling.lotto.exception.LowMoneyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    @DisplayName("Lotto 생성 시 LottoNumber " + Lotto.COUNT_OF_LOTTO_NUMBER  + "개 가지게 생성")
    @Test
    void should_create_lotto_when_correct_lottoNumber() {
        // when
        final Lotto lotto = new FixtureLotto();

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("Lotto 생성 시 LottoNumber " + Lotto.COUNT_OF_LOTTO_NUMBER  + "개 보다 적을 시 예외처리")
    @Test
    void should_throw_InvalidCountOfLottoNumberException_lotto_when_shorterThan_countOfLotto() {
        // given
        final Set<LottoNumber> lottoNumbers = new FixtureLottoNumbers(Lotto.COUNT_OF_LOTTO_NUMBER - 1);

        // when / then
        Assertions.assertThatExceptionOfType(InvalidCountOfLottoNumberException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("Lotto 생성 시 LottoNumber " + Lotto.COUNT_OF_LOTTO_NUMBER  + "개 보다 클 시 예외처리")
    @Test
    void should_throw_InvalidCountOfLottoNumberException_lotto_when_longerThan_countOfLotto() {
        // given
        final Set<LottoNumber> lottoNumbers = new FixtureLottoNumbers(Lotto.COUNT_OF_LOTTO_NUMBER + 1);

        // when / then
        Assertions.assertThatExceptionOfType(InvalidCountOfLottoNumberException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("Lotto 가 같은 값을 가질 경우 같은 객체 확인")
    @Test
    void should_return_true_when_equals_sameLotto() {
        // when
        final Lotto target = new FixtureLotto();
        final Lotto expect = new FixtureLotto();

        // then
        assertThat(target).isEqualTo(expect);
    }

    @DisplayName("Lotto 의 lottoNumber 매칭 갯수 확인")
    @Test
    void should_allMatch_countOfMatch() {
        final Lotto target = new FixtureLotto();
        final Lotto expect = new FixtureLotto();

        // when
        final int countOfMatch = target.countOfMatch(expect);

        // then
        assertThat(countOfMatch).isEqualTo(Lotto.COUNT_OF_LOTTO_NUMBER);
    }

    @DisplayName("Lotto 를 돈으로 구매")
    @Test
    void can_buy_lotto_by_money() {
        // given
        final Money money = new Money(Lotto.PRICE_VALUE);

        // when
        final Lotto lotto = new FixtureLotto();

        // then
        money.buy(lotto);
    }

    @DisplayName("Lotto 를 적은 돈으로 구매 시 예외처리")
    @Test
    void should_throw_LowMoneyException_when_lowBalance() {
        // given
        final Money money = new Money(Lotto.PRICE_VALUE - 1);
        final Lotto lotto = new FixtureLotto();

        // when / then
        assertThatExceptionOfType(LowMoneyException.class)
                .isThrownBy(() -> {
                    money.buy(lotto);
                });
    }

    @DisplayName("Lotto 에 해당 번호 포함 확인 ")
    @Test
    void should_return_contains() {
        // given
        final Lotto lotto = new FixtureLotto();
        final LottoNumber lottoNumber = new LottoNumber(1);

        // when
        boolean isContains = lotto.contains(lottoNumber);

        // then
        assertThat(isContains).isTrue();
    }
}
