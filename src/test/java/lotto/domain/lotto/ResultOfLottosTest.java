package lotto.domain.lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class ResultOfLottosTest {
    @Nested
    @DisplayName("numberOfMatchCount() 테스트")
    class NumberOfMatchCount {
        @Test
        @DisplayName("matchCount를 key로 가지는 값이 없는 경우 0을 반환한다.")
        void testNonExistedMatchCount() {
            ResultOfLottos resultOfLottos = new ResultOfLottos();
            assertThat(resultOfLottos.numberOfMatchCount(3)).isEqualTo(0);
        }

        @Test
        @DisplayName("matchCount를 key로 가지는 값이 있는 경우 해당 값을 반환한다.")
        void testExistedMatchCount() {
            ResultOfLottos resultOfLottos = new ResultOfLottos(
                    new HashMap<>(){{
                        put(3, 1);
                    }});

            assertThat(resultOfLottos.numberOfMatchCount(3)).isEqualTo(1);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0:0", "3:1:1", "3:3:3"}, delimiter = ':')
    @DisplayName("increaseNumberOfMatchCount(): matchCount를 key로 가지는 값을 1 증가시킨다.")
    void testIncreaseNumberOfMatchCount(int matchCount, int numberOfIncrease, int expected) {
        ResultOfLottos resultOfLottos = new ResultOfLottos();

        for (int i = 0; i < numberOfIncrease; i++) {
            resultOfLottos.increaseNumberOfMatchCount(matchCount);
        }

        assertThat(resultOfLottos.numberOfMatchCount(matchCount)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:1", "3:2", "4:1", "5:1", "6:1"}, delimiter = ':')
    @DisplayName("totalWinningMoney(): 총 당첨금을 반환한다.")
    void testTotalWinningMoney(int matchCount, int numberOfMatchCount) {
        ResultOfLottos resultOfLottos = new ResultOfLottos(
                new HashMap<>(){{
                    put(matchCount, numberOfMatchCount);
                }});


        int expected = Rank.findRank(matchCount).winningMoney() * numberOfMatchCount;
        assertThat(resultOfLottos.totalWinningMoney()).isEqualTo(expected);
    }
}
