package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @DisplayName("각 등수에 대한 당첨 여부 테스트")
    @Test
    public void drawResultValidTest(){
        DrawResult first = DrawResult.valueOfRank(1);
        DrawResult second = DrawResult.valueOfRank(2);
        DrawResult third = DrawResult.valueOfRank(3);
        DrawResult fourth = DrawResult.valueOfRank(4);

        assertAll(
                ()->assertThat(first.getMoney()).isEqualTo(2000000000L),
                ()->assertThat(first.isWinning()).isEqualTo(true),
                ()->assertThat(first.getMatchNum()).isEqualTo(6),
                ()->assertThat(second.getMoney()).isEqualTo(1500000L),
                ()->assertThat(second.isWinning()).isEqualTo(true),
                ()->assertThat(second.getMatchNum()).isEqualTo(5),
                ()->assertThat(third.getMoney()).isEqualTo(50000L),
                ()->assertThat(third.isWinning()).isEqualTo(true),
                ()->assertThat(third.getMatchNum()).isEqualTo(4),
                ()->assertThat(fourth.getMoney()).isEqualTo(5000L),
                ()->assertThat(fourth.isWinning()).isEqualTo(true),
                ()->assertThat(fourth.getMatchNum()).isEqualTo(3)
        );


    }
}
