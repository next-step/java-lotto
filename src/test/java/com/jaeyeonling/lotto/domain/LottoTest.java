package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.InvalidCountOfLottoNumberException;
import com.jaeyeonling.lotto.exception.LowMoneyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    @DisplayName("Lotto 생성 시 LottoNumber " + Lotto.COUNT_OF_LOTTO_NUMBER  + "개 가지게 생성")
    @Test
    void should_create_lotto_when_correct_lottoNumber() {
        // given
        final Set<LottoNumber> lottoNumbers = getLottoNumbers(Lotto.COUNT_OF_LOTTO_NUMBER);

        // when
        final Lotto lotto = new Lotto(lottoNumbers);

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("Lotto 생성 시 LottoNumber " + Lotto.COUNT_OF_LOTTO_NUMBER  + "개 보다 적을 시 예외처리")
    @Test
    void should_throw_InvalidCountOfLottoNumberException_lotto_when_shorterThan_countOfLotto() {
        // given
        final Set<LottoNumber> lottoNumbers = getLottoNumbers(Lotto.COUNT_OF_LOTTO_NUMBER - 1);

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
        final Set<LottoNumber> lottoNumbers = getLottoNumbers(Lotto.COUNT_OF_LOTTO_NUMBER + 1);

        // when / then
        Assertions.assertThatExceptionOfType(InvalidCountOfLottoNumberException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("Lotto 가 같은 값을 가질 경우 같은 객체 확인")
    @Test
    void should_return_true_when_equals_sameLotto() {
        // given
        final Set<LottoNumber> lottoNumbers = getLottoNumbers(Lotto.COUNT_OF_LOTTO_NUMBER);

        // when
        final Lotto target = new Lotto(lottoNumbers);
        final Lotto expect = new Lotto(lottoNumbers);

        // then
        assertThat(target).isEqualTo(expect);
    }

    @DisplayName("Lotto 의 lottoNumber 매칭 갯수 확인")
    @Test
    void should_allMatch_countOfMatch() {
        // given
        final Set<LottoNumber> lottoNumbers = getLottoNumbers(Lotto.COUNT_OF_LOTTO_NUMBER);

        final Lotto target = new Lotto(lottoNumbers);
        final Lotto expect = new Lotto(lottoNumbers);

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
        final Set<LottoNumber> lottoNumbers = getLottoNumbers(Lotto.COUNT_OF_LOTTO_NUMBER);

        // when
        final Lotto lotto = new Lotto(lottoNumbers);

        // then
        money.buy(lotto);
    }

    @DisplayName("Lotto 를 적은 돈으로 구매 시 예외처리")
    @Test
    void should_throw_LowMoneyException_when_lowBalance() {
        // given
        final Money money = new Money(Lotto.PRICE_VALUE - 1);
        final Set<LottoNumber> lottoNumbers = getLottoNumbers(Lotto.COUNT_OF_LOTTO_NUMBER);
        final Lotto lotto = new Lotto(lottoNumbers);

        // when / then
        assertThatExceptionOfType(LowMoneyException.class)
                .isThrownBy(() -> {
                    money.buy(lotto);
                });
    }

    private Set<LottoNumber> getLottoNumbers(final int countOfLottoNumber) {
        final Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int lottoNumber = LottoNumber.MIN; lottoNumber <= countOfLottoNumber; lottoNumber++) {
            lottoNumbers.add(new LottoNumber(lottoNumber));
        }

        return lottoNumbers;
    }
}
