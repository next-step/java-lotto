package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RankTest {

    @DisplayName("등수유형별로 생성되는지 확인")
    @Test
    void test() {
        assertThat(Rank.values().length).isEqualTo(5);
    }

    @DisplayName("맞춘 횟수에 맞는 당첨금")
    @ParameterizedTest
    @CsvSource(value = {"6:2000000000", "5:1500000", "4:50000", "3:5000", "0:0",}, delimiter = ':')
    void inquirePrizeMoney_맞춘_횟수에_맞는_당첨금(int input, int result) {
        assertThat(Rank.inquireWinningMoney(input)).isEqualTo(result);
    }

    @DisplayName("맞춘 횟수가 0 미만, 6을 초과했을때 예외 throw")
    @ParameterizedTest
    @ValueSource(ints = {-5, 46})
    void inquirePrizeMoney_맞춘_횟수(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Rank.inquireWinningMoney(input);
        }).withMessageMatching("맞춘 횟수는 0에서 6 사이여야 합니다.");
    }

}
