package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DrawResultTest {

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
                    DrawResult drawResult = DrawResult.valueOfMatchNum(matchNum);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랭크에 맞는 LottoResult 를 가져오는지 테스트")
    @ParameterizedTest
    @ValueSource(
            ints = {
                    0,
                    1,
                    2,
                    3,
                    4,
                    5,
                    6
            }
    )
    public void getMatchNumLottoResultTest(int matchNum) {
        DrawResult drawResult = DrawResult.valueOfMatchNum(matchNum);
        assertThat(drawResult).isNotNull();
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
                    DrawResult drawResult = DrawResult.valueOfRank(rank);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랭크에 맞는 LottoResult 를 가져오는지 테스트")
    @ParameterizedTest
    @ValueSource(
            ints = {
                    1,
                    2,
                    3,
                    4,
                    5,
                    6,
                    7
            }
    )
    public void getMatchRankLottoResultTest(int rank) {
        DrawResult drawResult = DrawResult.valueOfRank(rank);
        assertThat(drawResult).isNotNull();
    }

}
