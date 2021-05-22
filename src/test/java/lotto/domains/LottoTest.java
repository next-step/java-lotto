package lotto.domains;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private LottoNumbers winningNumber;

    @BeforeEach
    void setUp() {
        this.winningNumber = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    private static Stream<Arguments> provideListAndExpectedNumber() {
        return Stream.of(
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))), 6),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 16))), 5),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 15, 16))), 4),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 14, 15, 16))), 3),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 13, 14, 15, 16))), 2),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 12, 13, 14, 15, 16))), 1),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(11, 12, 13, 14, 15, 16))), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideListAndExpectedNumber")
    void 당첨번호_테스트(Lotto lotto, int expectedNumber) {
        assertThat(lotto.matchingNumberCount(winningNumber)).isEqualTo(expectedNumber);
    }

    @Test
    void 로또번호_가져오기_테스트() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));
        assertThat(lotto.lottoNumbers()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
