package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.LottoRank;

public class LottoRankTest {

    @ParameterizedTest(name = "일치 갯수에 따른 상금 테스트")
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    public void amountOfHit(int input, int expected) {
        // given & when & then
        assertThat(LottoRank.of(input).amount()).isEqualTo(expected);
    }
}
