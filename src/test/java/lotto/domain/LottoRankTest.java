package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"6:1등", "5:2등", "4:3등", "3:4등", "2:미당첨", "1:미당첨", "0:미당첨"}, delimiter = ':')
    @DisplayName("로또 번호가 맞은 개수에 대한 순위를 반환한다.")
    void match(int matchCount, String expected) {

        assertThat(LottoRank.getLottoRank(matchCount).getRanking()).isEqualTo(expected);
    }
}
