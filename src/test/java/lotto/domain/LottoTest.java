package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static lotto.domain.Lotto.PRICE;
import static lotto.utils.StringParser.stringToIntegerList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void test_로또판매() {
        Lotto lotto = new Lotto();
        lotto.sellLotto(32500L);
        assertThat(lotto.lottoNumbersCount()).isEqualTo(32);
    }

    @Test
    void test_등수별카운드() {
        Lotto lotto = new Lotto(List.of(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)), new LottoNumbers(List.of(1, 2, 3, 4, 5, 7))));
        WinningNumbers winningLottoNumbers = new WinningNumbers(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7));

        EnumMap<Rank, Integer> countPerPrize = new EnumMap<>(Rank.class);
        countPerPrize.put(Rank.FIRST_PLACE, 1);
        countPerPrize.put(Rank.SECOND_PLACE, 1);
        for (Rank rank : Rank.values()) {
            countPerPrize.putIfAbsent(rank, 0);
        }

        assertThat(countPerPrize.toString()).isEqualTo(lotto.makeStatistics(winningLottoNumbers).toString());
    }

    @Test
    void test_당첨금계산() {
        Lotto lotto = new Lotto(List.of(new LottoNumbers(stringToIntegerList("1, 2, 3, 4, 5, 6")), new LottoNumbers(stringToIntegerList("1, 2, 3, 4, 5, 7"))));
        WinningNumbers winningLottoNumbers = new WinningNumbers(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7));

        assertThat(lotto.calcWinningAmount(winningLottoNumbers)).isEqualTo(Rank.FIRST_PLACE.getPrizeAmount() + Rank.SECOND_PLACE.getPrizeAmount());
    }

    @Test
    void test_수익률계산() {
        Lotto lotto = new Lotto(List.of(new LottoNumbers(stringToIntegerList("1, 2, 3, 4, 5, 6")), new LottoNumbers(stringToIntegerList("1, 2, 3, 4, 5, 7"))));
        WinningNumbers winningLottoNumbers = new WinningNumbers(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7));

        double rateOfReturn = (double) (Rank.FIRST_PLACE.getPrizeAmount() + Rank.SECOND_PLACE.getPrizeAmount()) / (PRICE * 2);
        assertThat(lotto.calcRateOfReturn(winningLottoNumbers)).isEqualTo(rateOfReturn);
    }
}