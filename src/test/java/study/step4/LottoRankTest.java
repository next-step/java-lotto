package study.step4;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.step4.domain.LottoRank;

public class LottoRankTest {

    @ParameterizedTest(name = "통계 일치 갯수에 따른 상금 테스트")
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    public void moneyOfHit(int input, int expected) {
        assertThat(LottoRank.of(input, false).getMoney()).isEqualTo(expected);
    }

    @Test
    @DisplayName("보너스 상금 테스트")
    public void bonus() {
        // given
        int hit = 5;
        int money = 30000000;
        // when & then
        assertThat(LottoRank.of(hit, true).getMoney()).isEqualTo(money);
    }
}
