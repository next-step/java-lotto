package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,MISS",
            "2,MISS",
            "3,FIFTH",
            "4,FOURTH",
            "5,THIRD",
            "6,FIRST"
    })
    @DisplayName("맞은 갯수에 맞게 로또랭킹을 가져와야 한다")
    public void 맞은_갯수에_맞게_로또랭킹을_가져와야_한다(int countOfMatched, LottoRank except) {
        assertThat(LottoRank.valueOf(countOfMatched, false))
                .isEqualTo(except);
    }
}
