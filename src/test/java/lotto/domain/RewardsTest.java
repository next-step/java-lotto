package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewardsTest {
    @ParameterizedTest
    @CsvSource(value = {"3:FOURTH:5000", "4:THIRD:50000", "5:SECOND:1500000", "6:FIRST:2000000000",}, delimiter = ':')
    @DisplayName("당첨 숫자 갯수에 맞는 당첨 순위 가져오기")
    public void getRewardsTest(int matches, String place, int prize) {
        assertThat(Rewards.getRewards(matches).toString()).isEqualTo(place);
        assertThat(Rewards.getRewards(matches).getPrize()).isEqualTo(prize);
    }

    @Test
    @DisplayName("상금 범위 이외의 당첨 숫자 갯수 오류 테스트")
    public void getRewardsRangeErrorTest() {
        assertThatThrownBy(() -> Rewards.getRewards(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("상금 범위가 아닙니다.");
    }

    @Test
    @DisplayName("전체 상금 계산 테스트")
    public void getWholePrizeTest() {
        Map<Integer, Integer> result = new HashMap<>();

        result.put(3, 4);
        result.put(4, 0);
        result.put(5, 1);
        result.put(6, 1);

        assertThat(Rewards.getWholePrize(result)).isEqualTo(2001520000);
    }
}