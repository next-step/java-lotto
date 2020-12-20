package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class RankTest {

    @ParameterizedTest
    @DisplayName("로또 번호 갯수 대 상금표 테스트")
    @CsvSource({"0,0", "1,0", "2,0", "3,5000", "4,50000", "5,1500000", "6,2000000000"})
    void getWinningMoneyTest(int input, int expected) {
        assertThat(Rank.valueOf(input, false).getWinningMoney()).isEqualTo(expected);
    }
}