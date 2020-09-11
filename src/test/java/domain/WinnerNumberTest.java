package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerNumberTest {
    @Test
    void validateBonusTest() {
        assertThatThrownBy(() -> {
            WinnerNumber winnerNumber = new WinnerNumber
                    ("1,2,3,4,5,6".split(","), 6);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Err!");
    }


    @Test
    void checkAllLottosWithWinnerLotto() {

        String lastWinnerNumber = "1,2,3,4,5,6";
        String[] input = lastWinnerNumber.split(",");
        int bonus = 7;
        Set<LottoNo> onelotto = new HashSet<>(Arrays
                .asList(new LottoNo(1)
                        , new LottoNo(2)
                        , new LottoNo(3)
                        , new LottoNo(4)
                        , new LottoNo(8)
                        , new LottoNo(9)));

        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(onelotto));

        RankRecord rankRecord = new WinnerNumber(input, bonus)
                .checkAllLottosWithWinnerLotto(lottos);

        assertThat(rankRecord.sumOfPrice().getMoney()).isEqualTo(50000);
    }
}
