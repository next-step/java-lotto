package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoRewardTest {
    @DisplayName("생성자 테스트")
    @Test
    public void test_LottoReward_Contructor() {
        assertThat(LottoReward.of(3, 5000, 0))
                .isEqualTo(LottoReward.of(3, 5000, 0));
    }

    @DisplayName("LottoReward update")
    @Test
    public void test_updateCount() {
        LottoReward lottoReward = LottoReward.of(3, 5000, 0);
        assertThat(lottoReward.updateCount(3))
                .isEqualTo(LottoReward.of(3, 5000, 3));
    }

    private static Stream<Arguments> provideCalculateLottoRewardResult() {
        return Stream.of(
                Arguments.of(LottoReward.of(3, 5000, 3), 15000),
                Arguments.of(LottoReward.of(3, 5000, 1), 5000),
                Arguments.of(LottoReward.of(3, 50000, 0), 0),
                Arguments.of(LottoReward.of(3, 1500000, 0), 0),
                Arguments.of(LottoReward.of(3, 2000000000, 0), 0)
        );
    }

    @DisplayName("리워드 계산")
    @ParameterizedTest
    @MethodSource("provideCalculateLottoRewardResult")
    public void test_calculate(LottoReward lottoReward, int reward) {
        assertThat(lottoReward.calculate()).isEqualTo(reward);
    }
}
