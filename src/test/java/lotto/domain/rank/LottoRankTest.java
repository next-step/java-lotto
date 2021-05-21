package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,false,MISS",
            "2,false,MISS",
            "3,false,FIFTH",
            "4,false,FOURTH",
            "5,false,THIRD",
            "5,true,SECOND",
            "6,false,FIRST"
    })
    @DisplayName("맞은 갯수에 맞게 로또랭킹을 가져와야 한다")
    public void 맞은_갯수에_맞게_로또랭킹을_가져와야_한다(int countOfMatched, boolean bonusMatched, LottoRank except) {
        assertThat(LottoRank.valueOf(countOfMatched, bonusMatched))
                .isEqualTo(except);
    }
}
