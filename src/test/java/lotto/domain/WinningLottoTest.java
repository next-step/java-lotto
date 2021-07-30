package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    @CsvSource( value = {
            "1,2,3,4,5,6|1,2,3,4,5,6|FIRST_PLACE",
            "1,2,3,4,5,6|1,2,3,4,5,7|SECOND_PLACE",
            "1,2,3,4,5,6|1,2,3,4,7,8|THREE_PLACE",
            "1,2,3,4,5,6|1,2,3,7,8,9|FOUR_PLACE"
    }, delimiter = '|')
    @DisplayName("rank Test")
    @ParameterizedTest
    public void rankTest(String strLottoNumbers, String strPrizeLottoNumbers, String rankName) {
        Lotto lotto = Lotto.parse(strLottoNumbers);
        WinningLotto winningLotto = new WinningLotto(
                Lotto.parse(strPrizeLottoNumbers)
        );

        LottoRank expertRank = LottoRank.valueOf(rankName);

        assertThat(winningLotto.rank(lotto))
                .isEqualTo(expertRank);
    }
}