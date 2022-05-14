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
    @DisplayName("복권들의 총 당첨금을 계산해서 반환한다.")
    void calculateTotalWinPrice() {
        Lotto rankFifthLotto1 = Lotto.valueOf(createLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto rankFifthLotto2 = Lotto.valueOf(createLottoNumbers(1, 2, 3, 7, 8, 9));
        Lotto rankMissLotto = Lotto.valueOf(createLottoNumbers(11, 12, 13, 14, 15, 16));

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(rankFifthLotto1);
        lottoList.add(rankFifthLotto2);
        lottoList.add(rankMissLotto);

        Lottos lottos = new Lottos(lottoList);
        lottos.confirmAll(new LottoNumbers("1, 2, 3, 20, 21, 22"), LottoNumber.valueOf(23));

        assertThat(lottos.calculateTotalWinPrice()).isEqualTo(Rank.FIFTH.winPrice() + Rank.FIFTH.winPrice());
    }

    @Test
    @DisplayName("복권중에 해당하는 Rank 개수를 반환한다.")
    void countMatchResult() {
        Lotto rankFifthLotto1 = Lotto.valueOf(createLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto rankFifthLotto2 = Lotto.valueOf(createLottoNumbers(1, 2, 3, 7, 8, 9));
        Lotto rankMissLotto = Lotto.valueOf(createLottoNumbers(11, 12, 13, 14, 15, 16));

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(rankFifthLotto1);
        lottoList.add(rankFifthLotto2);
        lottoList.add(rankMissLotto);

        Lottos lottos = new Lottos(lottoList);
        lottos.confirmAll(new LottoNumbers("1, 2, 3, 20, 21, 22"), LottoNumber.valueOf(23));

        assertThat(lottos.countMatchResult(Rank.FIFTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("3개의 복권 중 수동 복권이 2개일때 2개를 반환한다.")
    void countManualLotto() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.valueOf(createLottoNumbers(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.valueOf(createLottoNumbers(1, 2, 3, 7, 8, 9)));
        lottos.add(Lotto.createAutoLotto());

        assertThat(new Lottos(lottos).countManualLotto()).isEqualTo(2);
    }

    private LottoNumbers createLottoNumbers(int... numbers) {
        TreeSet<LottoNumber> lottoNumberTreeSet = new TreeSet<>();
        for (int number : numbers) {
            lottoNumberTreeSet.add(LottoNumber.valueOf(number));
        }
        return new LottoNumbers(lottoNumberTreeSet);
    }
}