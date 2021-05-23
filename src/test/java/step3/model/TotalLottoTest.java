package step3.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.constant.WinnerPrice;

public class TotalLottoTest {

    @Test
    @DisplayName("size 반환 테스트")
    void sizeTest() {
        TotalLotto totalLotto = new TotalLotto();
        assertThat(totalLotto.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("로또 1개를 add하는 테스트")
    void addTest() {
        TotalLotto totalLotto = new TotalLotto();
        totalLotto.addLottoOne(RandomNumbersGenerator.createNumbers());
        totalLotto.addLottoOne(RandomNumbersGenerator.createNumbers());
        assertThat(totalLotto.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 수익률 테스트")
    void getBenefitTest() {
        TotalLotto totalLotto = new TotalLotto();
        addLotto(totalLotto, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumbers victoryNumber = new LottoNumbers(
            new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9)));
        assertThat(totalLotto.getBenefit(victoryNumber, new Price(14000)))
            .isEqualTo("0.35");
        victoryNumber = new LottoNumbers(
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 9)));
        assertThat(totalLotto.getBenefit(victoryNumber, new Price(14000)))
            .isEqualTo("3.57");
    }

    @Test
    @DisplayName("당첨 번호를 받아  등수별 총 수를 반환한다.")
    void winningLottoTest() {
        TotalLotto totalLotto = new TotalLotto();
        setLottos(totalLotto);

        Map<WinnerPrice, Long> winning = totalLotto.groupByWinnerPrice(
            new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9))));

        assertThat(winning.get(WinnerPrice.FIRST)).isEqualTo(1);
        assertThat(winning.get(WinnerPrice.SECOND)).isEqualTo(1);
        assertThat(winning.get(WinnerPrice.THIRD)).isEqualTo(2);
        assertThat(winning.get(WinnerPrice.FOURTH)).isEqualTo(1);
    }

    private void setLottos(TotalLotto totalLotto) {
        addLotto(totalLotto, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        addLotto(totalLotto,
            new ArrayList<>(Arrays.asList(1, 2, 3, 7, 10, 11)));
        addLotto(totalLotto,
            new ArrayList<>(Arrays.asList(1, 2, 3, 8, 10, 11)));
        addLotto(totalLotto, new ArrayList<>(Arrays.asList(1, 2, 3, 7, 9, 10)));
        addLotto(totalLotto, new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9)));
    }

    private void addLotto(TotalLotto totalLotto, ArrayList<Integer> arrayList) {
        totalLotto.addLottoOne(arrayList);
    }
}
