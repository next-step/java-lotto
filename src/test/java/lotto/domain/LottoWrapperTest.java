package lotto.domain;

import lotto.enumerate.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWrapperTest {

    @Test
    @DisplayName("1등 당첨 Rank 조회 테스트")
    void getResultRanksTest1() {
        int bonusNumber = 0;
        LottoNumbersWrapper testLottoNumbersWrapper = new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, 6));

        Lotto lotto = new Lotto(testLottoNumbersWrapper);
        LottoWrapper lottoWrapper = new LottoWrapper(Arrays.asList(lotto));
        List<Rank> resultRanks = lottoWrapper.getResultRanks(testLottoNumbersWrapper, bonusNumber);

        assertThat(resultRanks).hasSize(1);
        assertThat(resultRanks.get(0)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등 당첨 Rank 조회 테스트")
    void getResultRanksTest2() {
        int bonusNumber = 0;
        LottoNumbersWrapper collectNumbersWrapper = new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbersWrapper testLottoNumbersWrapper = new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, bonusNumber));

        Lotto lotto = new Lotto(testLottoNumbersWrapper);
        LottoWrapper lottoWrapper = new LottoWrapper(Arrays.asList(lotto));
        List<Rank> resultRanks = lottoWrapper.getResultRanks(collectNumbersWrapper, bonusNumber);

        assertThat(resultRanks).hasSize(1);
        assertThat(resultRanks.get(0)).isEqualTo(Rank.SECOND);
    }
}