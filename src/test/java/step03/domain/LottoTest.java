package step03.domain;

import exception.DuplicatedLottoNumberException;
import exception.InValidSizeOfLottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step01.Int;
import step02.domain.WinningCounter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {
    List<LottoBall> lottoBalls;

    @BeforeEach
    void setup() {
        lottoBalls = Arrays.asList(
                LottoBall.valueOf(8),
                LottoBall.valueOf(21),
                LottoBall.valueOf(23),
                LottoBall.valueOf(41),
                LottoBall.valueOf(42),
                LottoBall.valueOf(43)
        );
    }


    @DisplayName("생성자")
    @Test
    void test_constructor() {
        assertThat(Lotto.of(lottoBalls)).isEqualTo(Lotto.of(lottoBalls));
    }

    private static Stream<Arguments> provideTargetLottoResult() {
        return Stream.of(
                Arguments.of(Lotto.intOf(Arrays.asList(8, 1, 2, 3, 4, 5)), 1),
                Arguments.of(Lotto.intOf(Arrays.asList(8, 21, 2, 3, 4, 5)), 2),
                Arguments.of(Lotto.intOf(Arrays.asList(8, 21, 23, 3, 4, 5)), 3),
                Arguments.of(Lotto.intOf(Arrays.asList(8, 21, 23, 41, 4, 5)), 4),
                Arguments.of(Lotto.intOf(Arrays.asList(8, 21, 23, 41, 42, 5)), 5),
                Arguments.of(Lotto.intOf(Arrays.asList(8, 21, 23, 41, 42, 43)), 6)
        );
    }

    @DisplayName("다른 로또와 일치하는 번호의 개수 count")
    @ParameterizedTest
    @MethodSource("provideTargetLottoResult")
    void test_matchCount(Lotto targetLotto, Integer expect) {
        assertThat(Lotto.of(lottoBalls).matchCount(targetLotto)).isEqualTo(expect);
    }

    private static Stream<Arguments> provideLottoBallContainingResult() {
        return Stream.of(
                Arguments.of(LottoBall.valueOf(8), true),
                Arguments.of(LottoBall.valueOf(2), false),
                Arguments.of(LottoBall.valueOf(21), true),
                Arguments.of(LottoBall.valueOf(4), false)
        );
    }

    @DisplayName("로또에 특정 번호가 있는지 검사")
    @ParameterizedTest
    @MethodSource("provideLottoBallContainingResult")
    void test_isContaining(LottoBall lottoBall, boolean expect) {
        assertThat(Lotto.of(lottoBalls).isContaining(lottoBall))
                .isEqualTo(expect);
    }

    @DisplayName("로또 번호의 정렬")
    @Test
    void test_arrange() {
        assertThat(Lotto.of(Arrays.asList(
                LottoBall.valueOf(21),
                LottoBall.valueOf(8),
                LottoBall.valueOf(43),
                LottoBall.valueOf(23),
                LottoBall.valueOf(42),
                LottoBall.valueOf(41)
        ))).isEqualTo(Lotto.of(lottoBalls));
    }

    @DisplayName("중복값 예외 처리")
    @Test
    void test_validateUnique() {
        assertThatExceptionOfType(DuplicatedLottoNumberException.class)
                .isThrownBy(() -> Lotto.of(Arrays.asList(
                        LottoBall.valueOf(8),
                        LottoBall.valueOf(8),
                        LottoBall.valueOf(43),
                        LottoBall.valueOf(23),
                        LottoBall.valueOf(42),
                        LottoBall.valueOf(41)
                )));
    }

    private static Stream<List<LottoBall>> provideInvalidSizeOfLottoResult() {
        return Stream.of(
                Arrays.asList(
                        LottoBall.valueOf(8),
                        LottoBall.valueOf(43),
                        LottoBall.valueOf(23),
                        LottoBall.valueOf(42),
                        LottoBall.valueOf(41)
                ),
                Arrays.asList(
                        LottoBall.valueOf(8),
                        LottoBall.valueOf(43),
                        LottoBall.valueOf(23),
                        LottoBall.valueOf(42),
                        LottoBall.valueOf(41),
                        LottoBall.valueOf(45),
                        LottoBall.valueOf(1)
                )
        );
    }

    @DisplayName("lotto size가 6이 아니면 예외 처리")
    @ParameterizedTest
    @MethodSource("provideInvalidSizeOfLottoResult")
    void test_validateSize(List<LottoBall> lotto) {
        assertThatExceptionOfType(InValidSizeOfLottoException.class)
                .isThrownBy(() -> Lotto.of(lotto));
    }


//    - public List<LottoNumber> getLotto()
}
