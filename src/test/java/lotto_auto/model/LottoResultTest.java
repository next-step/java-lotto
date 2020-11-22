package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoResultTest {

    @DisplayName("일치하는 수 범위가 이상할때 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(
            ints = {
                    -1,
                    7
            }
    )
    public void invalidMatchNumExceptionTest(int matchNum) {
        assertThatThrownBy(
                () -> {
                    LottoResult lottoResult = LottoResult.valueOfMatchNum(matchNum);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랭크가 잘못된 범위일때 예외 발생테스트")
    @ParameterizedTest
    @ValueSource(
            ints = {
                    0,
                    8
            }
    )
    public void invalidRankExceptionTest(int rank) {
        assertThatThrownBy(
                () -> {
                    LottoResult lottoResult = LottoResult.valueOfRank(rank);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
