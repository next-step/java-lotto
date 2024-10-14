package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStatics;
import lotto.domain.Rank;
import lotto.domain.WinNumber;

class LottoStaticsTest {

    @Test
    void 생성() {
        LottoStatics lottoStatics = new LottoStatics();

        assertThat(lottoStatics).isEqualTo(new LottoStatics());
    }

    @Test
    void 추가() {
        LottoStatics lottoStatics = new LottoStatics();

        lottoStatics.add(new Lotto());

        assertThat(lottoStatics).isEqualTo(new LottoStatics(List.of(new Lotto())));
    }

    @Test
    void 로또들과_당첨_번호를_넘기면_통계_결과를_준다() {
        List<Lotto> lottos = List.of(
            new Lotto(new LottoNumbers(1, 2, 3, 11, 12, 13)),
            new Lotto(new LottoNumbers(1, 2, 3, 4, 12, 7)),
            new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 8)),
            new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 8)),
            new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6))
        );
        LottoStatics lottoStatics = new LottoStatics(lottos);
        WinNumber winnerNumber = new WinNumber(1, 2, 3, 4, 5, 6);
        winnerNumber.addBonus(new BonusNumber(45));

        int resultThree = lottoStatics.findRank(winnerNumber, Rank.THREE);
        int resultFour = lottoStatics.findRank(winnerNumber, Rank.FOUR);
        int resultFive = lottoStatics.findRank(winnerNumber, Rank.FIVE);
        int resultSix = lottoStatics.findRank(winnerNumber, Rank.WIN);

        assertThat(resultThree).isEqualTo(1);
        assertThat(resultFour).isEqualTo(1);
        assertThat(resultFive).isEqualTo(2);
        assertThat(resultSix).isEqualTo(1);
    }

    @Test
    void 총상금을_계산한다() {
        List<Lotto> lottos = List.of(
            new Lotto(new LottoNumbers(8, 21, 23, 41, 42, 43)),
            new Lotto(new LottoNumbers(3, 5, 11, 16, 32, 38)),
            new Lotto(new LottoNumbers(7, 11, 16, 35, 36, 44)),
            new Lotto(new LottoNumbers(1, 8, 11, 31, 41, 42)),
            new Lotto(new LottoNumbers(13, 14, 16, 38, 42, 45)),
            new Lotto(new LottoNumbers(7, 11, 30, 40, 42, 43)),
            new Lotto(new LottoNumbers(2, 13, 22, 32, 38, 45)),
            new Lotto(new LottoNumbers(23, 25, 33, 36, 39, 41)),
            new Lotto(new LottoNumbers(1, 3, 5, 14, 22, 45)),
            new Lotto(new LottoNumbers(5, 9, 38, 41, 43, 44)),
            new Lotto(new LottoNumbers(2, 8, 9, 18, 19, 21)),
            new Lotto(new LottoNumbers(13, 14, 18, 21, 23, 35)),
            new Lotto(new LottoNumbers(17, 21, 29, 37, 42, 45)),
            new Lotto(new LottoNumbers(3, 8, 27, 30, 35, 44))
        );
        LottoStatics lottoStatics = new LottoStatics(lottos);
        WinNumber winnerNumber = new WinNumber(1, 2, 3, 4, 5, 6);
        winnerNumber.addBonus(new BonusNumber(45));

        long totalPrize = lottoStatics.totalPrize(winnerNumber);

        assertThat(totalPrize).isEqualTo(5000);
    }
}
