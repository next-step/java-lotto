package lotto.domain;

import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("3개의 복권 중 2개가 MatchResult.Three 경우 10000을 반환한다.")
    void calculateTotalWinPrice() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(createLottoNumbers(1, 2, 3, 7, 8, 9)));
        lottoList.add(new Lotto(createLottoNumbers(11, 12, 13, 14, 15, 16)));

        Lottos lottos = new Lottos(lottoList);
        lottos.confirmAll(LottoNumbers.createWinningNumbers(new String[]{"1", "2", "3", "20", "21", "22"}));

        assertThat(lottos.calculateTotalWinPrice()).isEqualTo(10000);
    }

    @Test
    @DisplayName("3개의 복권 중 2개가 4등 일때 4등의 개수를 구하면 2개를 반환한다.")
    void countMatchResult() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(createLottoNumbers(1, 2, 3, 7, 8, 9)));
        lottoList.add(new Lotto(createLottoNumbers(11, 12, 13, 14, 15, 16)));

        Lottos lottos = new Lottos(lottoList);
        lottos.confirmAll(LottoNumbers.createWinningNumbers(new String[]{"1", "2", "3", "20", "21", "22"}));

        assertThat(lottos.countMatchResult(Rank.FIFTH)).isEqualTo(2);
    }

    private LottoNumbers createLottoNumbers(int... numbers) {
        TreeSet<LottoNumber> lottoNumberTreeSet = new TreeSet<>();
        for (int number : numbers) {
            lottoNumberTreeSet.add(LottoNumber.valueOf(number));
        }
        return new LottoNumbers(lottoNumberTreeSet);
    }
}