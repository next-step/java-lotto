package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;
import com.jaeyeonling.lotto.exception.InvalidCountOfLottoNumberException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("Lotto 생성 시 LottoNumber " + Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO  + "개 가지게 생성")
    @Test
    void should_create_lotto_when_correct_lottoNumber() {
        // given
        final Set<LottoNumber> lottoNumbers = getLottoNumbers(Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO);

        // then
        new Lotto(lottoNumbers);
    }

    @DisplayName("Lotto 생성 시 LottoNumber " + Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO  + "개 보다 적을 시 예외처리")
    @Test
    void should_throw_InvalidCountOfLottoNumberException_lotto_when_shorterThan_countOfLotto() {
        // given
        final Set<LottoNumber> lottoNumbers = getLottoNumbers(Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO - 1);

        // then
        Assertions.assertThatExceptionOfType(InvalidCountOfLottoNumberException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("Lotto 생성 시 LottoNumber " + Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO  + "개 보다 클 시 예외처리")
    @Test
    void should_throw_InvalidCountOfLottoNumberException_lotto_when_longerThan_countOfLotto() {
        // given
        final Set<LottoNumber> lottoNumbers = getLottoNumbers(Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO + 1);

        // then
        Assertions.assertThatExceptionOfType(InvalidCountOfLottoNumberException.class)
                .isThrownBy(() -> {
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("Lotto 가 같은 값을 가질 경우 같은 객체 확인")
    @Test
    void should_return_true_when_equals_sameLotto() {
        // given
        final Set<LottoNumber> lottoNumbers = getLottoNumbers(Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO);

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
        final Set<LottoNumber> lottoNumbers = getLottoNumbers(Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO);

        final Lotto target = new Lotto(lottoNumbers);
        final Lotto expect = new Lotto(lottoNumbers);

        // when
        final int countOfMatch = target.countOfMatch(expect);

        // then
        assertThat(target.countOfMatch(expect)).isEqualTo(Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO);
    }

    private Set<LottoNumber> getLottoNumbers(final int countOfLottoNumbe) {
        final Set<LottoNumber> lottoNumbers = new HashSet<>();

        for (int lottoNumber = 1; lottoNumber <= countOfLottoNumbe; lottoNumber++) {
            lottoNumbers.add(new LottoNumber(lottoNumber));
        }

        return lottoNumbers;
    }
}
