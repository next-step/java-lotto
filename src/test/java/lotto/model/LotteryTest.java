package lotto.model;

import lotto.model.constants.Dividend;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    @Test
    @DisplayName("등수에 따른 모든 당첨금을 리턴한다.")
    void test1() {
        //given
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));
        BonusBall bonusBall = new BonusBall(LottoNumber.of(20));
        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoNumbers, bonusBall);

        TotalLottos totalLottos = new TotalLottos(List.of(
                new Lotto(Set.of(1, 2, 35, 29, 9, 11)),
                new Lotto(Set.of(1, 3, 16, 29, 9, 11)),
                new Lotto(Set.of(1, 2, 3, 4, 5, 20))
        ));

        Lottery lottery = new Lottery(winnerNumbers, totalLottos);
        //then
        assertThat(lottery.depositTotalMoney()).isEqualTo(30000000L);
    }

    @Test
    @DisplayName("구입금액과 당첨금에 따른 수입률을 보여준다")
    void test2() {
        //given
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));
        BonusBall bonusBall = new BonusBall(LottoNumber.of(20));
        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoNumbers, bonusBall);

        TotalLottos totalLottos = new TotalLottos(List.of(
                new Lotto(Set.of(1, 2, 35, 29, 9, 11)),
                new Lotto(Set.of(1, 3, 16, 29, 9, 11)),
                new Lotto(Set.of(1, 2, 3, 4, 5, 20))
        ));

        Lottery lottery = new Lottery(winnerNumbers, totalLottos);
        //then
        assertThat(lottery.getInvestment()).isEqualTo(10000.0);
    }

    @Test
    @DisplayName("당첨된 결과에 맞는 개수를 리턴한다.")
    void test3() {
        //given
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));
        BonusBall bonusBall = new BonusBall(LottoNumber.of(20));
        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoNumbers, bonusBall);

        TotalLottos totalLottos = new TotalLottos(List.of(
                new Lotto(Set.of(1, 2, 3, 4, 9, 11)),
                new Lotto(Set.of(1, 3, 5, 6, 9, 11)),
                new Lotto(Set.of(1, 2, 3, 4, 5, 20))
        ));

        Lottery lottery = new Lottery(winnerNumbers, totalLottos);
        Map<Dividend, Integer> result = lottery.totalCorrect();
        //then
        assertThat(result.get(Dividend.SECOND)).isEqualTo(1);
        assertThat(result.get(Dividend.FOURTH)).isEqualTo(2);
    }
}