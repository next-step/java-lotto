package step3.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.constant.Rank;

public class TotalLottoTest {

    private TotalLotto totalLotto;

    @BeforeEach
    void setup() {
        List<LottoNumbers> list = new ArrayList<>();
        list.add(LottoNumbers.of("1, 2, 3, 4, 5, 6"));
        list.add(LottoNumbers.of("1, 2, 3, 7, 10, 11"));
        list.add(LottoNumbers.of("1, 2, 3, 7, 9, 10"));
        list.add(LottoNumbers.of("1, 2, 3, 7, 8, 9"));

        totalLotto = new TotalLotto(list);
    }

    @Test
    @DisplayName("로또 수익률 테스트")
    void getBenefitTest() {
        LottoNumbers victoryNumber = LottoNumbers.of("1, 2, 3, 7, 8, 9");
        assertThat(totalLotto.getBenefit(victoryNumber, new Price(14000)))
            .isEqualTo("142968.21");
        victoryNumber = LottoNumbers.of("11, 12, 13, 14, 15, 16");
        assertThat(totalLotto.getBenefit(victoryNumber, new Price(14000)))
            .isEqualTo("0.00");
        victoryNumber = LottoNumbers.of("7, 10, 11, 12, 13, 14");
        assertThat(totalLotto.getBenefit(victoryNumber, new Price(14000)))
            .isEqualTo("0.35");
        victoryNumber = LottoNumbers.of("1, 2, 3, 7, 8, 9", "10");
        assertThat(totalLotto.getBenefit(victoryNumber, new Price(14000)))
            .isEqualTo("145003.92");
    }

    @Test
    @DisplayName("당첨 번호를 받아  등수별 총 수를 반환한다.")
    void winningLottoTest() {

        Map<Rank, Long> winning = totalLotto
            .groupByWinnerPrice(LottoNumbers.of("1, 2, 3, 7, 8, 9"));

        assertThat(winning.get(Rank.FIRST)).isEqualTo(1);
        assertThat(winning.get(Rank.THIRD)).isEqualTo(1);
        assertThat(winning.get(Rank.THIRD)).isEqualTo(1);
        assertThat(winning.get(Rank.FOURTH)).isEqualTo(1);
    }

}
