package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStatics;
import lotto.domain.Rank;
import lotto.domain.WinNumber;

class RankTest {

    @Test
    void 총상금이_주어지면_수익률을_계산한다() {
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
        WinNumber winNumber = new WinNumber(1, 2, 3, 4, 5, 6);

        double ratio = Rank.ratio(lottoStatics.totalPrize(winNumber), 14000);

        assertThat(ratio).isEqualTo(0.35);
    }

    @Test
    void 상금을_등수에_맞게_계산한다() {
        long result = Rank.calculatePrize(3, Rank.THREE);

        assertThat(result).isEqualTo(15000);
    }
}
