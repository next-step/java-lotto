package lotto.domain;

import lotto.fixture.LottoNumberFixture;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumbersTest {

    @DisplayName("6개 보다 적거나 많은 수 번호를 가진 LottoNumbers를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 7, 8, 9})
    void isIncorrectAmounts(int count) {
        // given
        List<LottoNumber> values = LottoNumberFixture.로또_번호_생성(count);

        // when
        ThrowableAssert.ThrowingCallable callable = () -> LottoNumbers.from(values);

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("반드시 6개의 번호를 선택해야 합니다.");
    }

    @DisplayName("중복된 번호를 가진 LottoNumbers를 생성할 수 없다.")
    @Test
    void isDuplicated() {
        // given
        List<LottoNumber> values = LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 3, 4, 4, 5));

        // when
        ThrowableAssert.ThrowingCallable callable = () -> LottoNumbers.from(values);

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("중복된 번호를 선택할 수 없습니다.");
    }

    @DisplayName("로또 번호들이 몇 개 일치하는지 판단할 수 있다. ")
    @Test
    void matches() {
        // given
        LottoNumbers numbers = LottoNumbers.from(LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumbers target1 = LottoNumbers.from(LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 3, 4, 5, 7)));
        LottoNumbers target2 = LottoNumbers.from(LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumbers target3 = LottoNumbers.from(LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 3, 8, 9, 10)));

        // then
        assertAll(
                () -> Assertions.assertThat(numbers.matches(target1)).isEqualTo(5),
                () -> Assertions.assertThat(numbers.matches(target2)).isEqualTo(6),
                () -> Assertions.assertThat(numbers.matches(target3)).isEqualTo(3)
        );
    }
}
