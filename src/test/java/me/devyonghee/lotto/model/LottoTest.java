package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또")
class LottoTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() ->
                Lotto.from(LottoNumbers.from(
                        IntStream.rangeClosed(1, 6).mapToObj(LottoNumber::from).collect(Collectors.toList())
                )));
    }

    @Test
    @DisplayName("숫자들은 필수")
    void instance_nullNumbers_thrownNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> Lotto.from(null));
    }

    @ParameterizedTest
    @DisplayName("로또 번호는 6개")
    @MethodSource
    void instance_invalidNumber_thrownIllegalArgumentException(List<LottoNumber> numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.from(LottoNumbers.from(numbers)));
    }

    @ParameterizedTest(name = "[{index}] 1,2,3,4,5,6과 {0} 대해서 랭크를 계산하면 {1}")
    @DisplayName("1,2,3,4,5,6 로또에 대한 순위 계산")
    @MethodSource
    void rank(Lotto target, Rank expected) {
        //given
        Lotto lotto = lotto(1, 2, 3, 4, 5, 6);
        //when
        assertThat(lotto.rank(target)).isEqualTo(expected);
    }

    private static Stream<Arguments> instance_invalidNumber_thrownIllegalArgumentException() {
        return Stream.of(
                Arguments.of(Collections.singletonList(LottoNumber.from(1))),
                Arguments.of(IntStream.rangeClosed(1, 7).mapToObj(LottoNumber::from).collect(Collectors.toList()))
        );
    }

    private static Stream<Arguments> rank() {
        return Stream.of(
                Arguments.of(lotto(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(lotto(2, 3, 4, 5, 6, 7), Rank.SECOND),
                Arguments.of(lotto(3, 4, 5, 6, 7, 8), Rank.THIRD),
                Arguments.of(lotto(4, 5, 6, 7, 8, 9), Rank.FOURTH),
                Arguments.of(lotto(5, 6, 7, 8, 9, 10), Rank.NOTING)
        );
    }

    private static Lotto lotto(int first, int second, int third, int fourth, int fifth, int sixth) {
        return Lotto.from(LottoNumbers.from(
                Arrays.asList(
                        LottoNumber.from(first),
                        LottoNumber.from(second),
                        LottoNumber.from(third),
                        LottoNumber.from(fourth),
                        LottoNumber.from(fifth),
                        LottoNumber.from(sixth)
                )
        ));
    }
}
