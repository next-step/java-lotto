package study.step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.step3.domain.LottoRank;

public class LottoRankTest {

    @ParameterizedTest(name = "통계 일치 갯수에 따른 상금 테스트")
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    public void amountOfHit(int input, int expected) {
        assertThat(LottoRank.of(input, false).getAmount()).isEqualTo(expected);
    }

    @Test
    @DisplayName("보너스 상금 테스트")
    public void bonus() {
        int hit = 5;
        int amount = 30000000;
        assertThat(LottoRank.of(hit, true).getAmount()).isEqualTo(amount);
    }
}
