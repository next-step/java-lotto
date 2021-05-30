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

    @Test
    void 생성자_테스트() {
        assertThat(new Lotto()).isNotNull();
        assertThat(new Lotto(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)))).isNotNull();
        assertThat(new Lotto("1,2,3,4,5,6")).isNotNull();
    }

    private static Stream<Arguments> provideListAndExpectedMatchingNumber() {
        return Stream.of(
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))), 45, 6, 2_000_000_000),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 16))), 16, 5, 30_000_000),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 16))), 45, 5, 1_500_000),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 15, 16))), 45, 4, 50_000),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 14, 15, 16))), 45, 3, 5_000),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 13, 14, 15, 16))), 45, 2, 0),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(1, 12, 13, 14, 15, 16))), 45, 1, 0),
                Arguments.of(new Lotto(new LottoNumbers(Arrays.asList(11, 12, 13, 14, 15, 16))), 45, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideListAndExpectedMatchingNumber")
    void 당첨번호_매칭후_매칭정보_테스트(Lotto lotto, int bonusNumber, int expectedMatchingNumber, int expectedPayout) {
        lotto.matching(new WinningLotto(winningNumber, bonusNumber));
        assertThat(lotto.matchingInfo().matchingNumber()).isEqualTo(expectedMatchingNumber);
        assertThat(lotto.matchingInfo().getPayout()).isEqualTo(expectedPayout);
    }
}
