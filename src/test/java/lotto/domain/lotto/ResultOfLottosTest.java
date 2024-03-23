package lotto.domain.lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;

import static lotto.domain.Rank.FIFTH;
import static org.assertj.core.api.Assertions.assertThat;

class ResultOfLottosTest {
    @Nested
    @DisplayName("numberOfMatchCount() 테스트")
    class NumberOfMatchCount {
        @Test
        @DisplayName("matchCount를 key로 가지는 값이 없는 경우 0을 반환한다.")
        void testNonExistedMatchCount() {
            ResultOfLottos resultOfLottos = new ResultOfLottos();
            assertThat(resultOfLottos.numberOfMatchCount(FIFTH)).isEqualTo(0);
        }

        @Test
        @DisplayName("matchCount를 key로 가지는 값이 있는 경우 해당 값을 반환한다.")
        void testExistedMatchCount() {
            Rank rank = FIFTH;

            ResultOfLottos resultOfLottos = new ResultOfLottos(
                    new HashMap<>(){{
                        put(rank, 1);
                    }});

            assertThat(resultOfLottos.numberOfMatchCount(rank)).isEqualTo(1);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"FIFTH:0:0", "FIFTH:1:1", "FIFTH:3:3"}, delimiter = ':')
    @DisplayName("increaseNumberOfMatchCount(): rank를 key로 가지는 값을 1 증가시킨다.")
    void testIncreaseNumberOfMatchCount(Rank rank, int numberOfIncrease, int expected) {
        ResultOfLottos resultOfLottos = new ResultOfLottos();

        for (int i = 0; i < numberOfIncrease; i++) {
            resultOfLottos.increaseNumberOfMatchCount(rank);
        }

        assertThat(resultOfLottos.numberOfMatchCount(rank)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIFTH:1:false", "FIFTH:2:false", "FOURTH:1:false", "THIRD:1:false", "SECOND:1:true", "FIRST:1:false"}, delimiter = ':')
    @DisplayName("totalWinningMoney(): 총 당첨금을 반환한다.")
    void testTotalWinningMoney(Rank rank, int numberOfMatchCount) {
        ResultOfLottos resultOfLottos = new ResultOfLottos(
                new HashMap<>(){{
                    put(rank, numberOfMatchCount);
                }});

        int expected = rank.winningMoney() * numberOfMatchCount;
        assertThat(resultOfLottos.totalWinningMoney()).isEqualTo(expected);
    }
}
