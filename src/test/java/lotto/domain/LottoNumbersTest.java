package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static lotto.domain.LottoNumber.MAX_VALUE;
import static lotto.domain.LottoNumber.MIN_VALUE;
import static lotto.domain.LottoRule.NUMBERS_IN_GAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoNumbersTest {
    @ParameterizedTest
    @NullAndEmptySource
    void LottoNumbers는_numbers없이_생성시_예외를_발생시킨다(List<LottoNumber> lottoNumbers) {
        assertThatThrownBy(() -> {
            new LottoNumbers(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void LottoNumbers는_중복된_값으로_생성시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoNumbers(List.of(new LottoNumber(1), new LottoNumber(1)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void all은_최솟값부터_최댓값까지_목록을_반환한다() {
        LottoNumbers lottoNumbers = LottoNumbers.all();

        assertAll(
                () -> assertEquals(MAX_VALUE, lottoNumbers.size()),
                () -> assertEquals(new LottoNumber(MIN_VALUE), lottoNumbers.getLottoNumbers().get(0)),
                () -> assertEquals(new LottoNumber(MAX_VALUE), lottoNumbers.getLottoNumbers().get(lottoNumbers.size() - 1))
        );
    }

    @Test
    void getRandomNumbers는_size만큼_랜덤_numbers를_반환한다() {
        assertThat(LottoNumbers.all().getRandomNumbers(NUMBERS_IN_GAME).size())
                .isEqualTo(NUMBERS_IN_GAME);
    }

    @Test
    void match는_두_numbers의_겹치는_개수를_반환한다() {
        assertThat(LottoNumbers.all().match(LottoNumbers.all()))
                .isEqualTo(new Match(MAX_VALUE));
    }

    @Test
    void contains는_lottoNumber_포함_여부를_반환한다() {
        assertAll(
                () -> assertTrue(new LottoNumbers(List.of(new LottoNumber(1))).contains(new LottoNumber(1))),
                () -> assertFalse(new LottoNumbers(List.of(new LottoNumber(1))).contains(new LottoNumber(2)))
        );
    }
}
