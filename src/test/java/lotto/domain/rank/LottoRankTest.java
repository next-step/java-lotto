package lotto.domain.rank;

import lotto.domain.rank.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,MISS",
            "2,MISS",
            "3,FOURTH",
            "4,THIRD",
            "5,SECOND",
            "6,FIRST"
    })
    @DisplayName("맞은 갯수에 맞게 로또랭킹을 가져와야 한다")
    public void 맞은_갯수에_맞게_로또랭킹을_가져와야_한다(int countOfMatched, LottoRank except) {
        assertThat(LottoRank.valueOf(countOfMatched))
                .isEqualTo(except);
    }
}
