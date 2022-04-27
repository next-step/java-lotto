package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("우승 로또")
class WinnerLottoTest {

    @Test
    @DisplayName("로또와 로또 보너스 숫자로 우승 로또 정상 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> WinnerLotto.of(Lotto.auto(LottoNumbersTest.ONE_TO_SIX_NUMBERS), LottoNumber.from(7)));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("로또와 보너스 번호는 필수")
    void instance_nullArguments_thrownNullPointerException(Lotto lotto, LottoNumber bonusNumber) {
        assertThatNullPointerException().isThrownBy(() -> WinnerLotto.of(lotto, bonusNumber));
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 포함될 수 없음")
    void instance_containsBonusNumber_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> WinnerLotto.of(Lotto.auto(LottoNumbersTest.ONE_TO_SIX_NUMBERS), LottoNumber.from(1)));
    }

    @Test
    @DisplayName("주어진 로또들에 대해서 점수 계산")
    void score() {
        //given
        Lottos lottos = Lottos.from(Collections.singletonList(Lotto.auto(LottoNumbersTest.ONE_TO_SIX_NUMBERS)));
        //when, then
        assertThat(WinnerLotto.of(Lotto.auto(LottoNumbersTest.ONE_TO_SIX_NUMBERS), LottoNumber.from(7)).score(lottos))
                .isEqualTo(Score.from(Collections.singleton(Rank.FIRST)));
    }

    private static Stream<Arguments> instance_invalidNumber_thrownIllegalArgumentException() {
        return Stream.of(
                Arguments.of(Collections.singletonList(LottoNumber.from(1))),
                Arguments.of(IntStream.rangeClosed(1, 7).mapToObj(LottoNumber::from).collect(Collectors.toList()))
        );
    }

    private static Stream<Arguments> instance_nullArguments_thrownNullPointerException() {
        return Stream.of(
                Arguments.of(Lotto.auto(LottoNumbersTest.ONE_TO_SIX_NUMBERS), null),
                Arguments.of(null, LottoNumber.from(1))
        );
    }
}
