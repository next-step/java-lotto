package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    @Test
    @DisplayName("등수에 따른 당첨금을 리턴한다.")
    void test1() {
        //given
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                new LottoNumberValidate(1),
                new LottoNumberValidate(2),
                new LottoNumberValidate(3),
                new LottoNumberValidate(4),
                new LottoNumberValidate(5),
                new LottoNumberValidate(6)));
        BonusBall bonusBall = new BonusBall(new LottoNumberValidate(20));
        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoNumbers, bonusBall);

        Lottos lottos = new Lottos(List.of(
                new Lotto(Set.of(1, 2, 35, 29, 9, 11)),
                new Lotto(Set.of(1, 3, 16, 29, 9, 11)),
                new Lotto(Set.of(1, 2, 3, 4, 5, 20))
        ));

        Lottery lottery = new Lottery(winnerNumbers, lottos);
        //then
        assertThat(lottery.depositTotalMoney()).isEqualTo(30000000L);
    }

    @Test
    @DisplayName("구입금액과 당첨금에 따른 수입률을 보여준다")
    void test2() {
        //given
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                new LottoNumberValidate(1),
                new LottoNumberValidate(2),
                new LottoNumberValidate(3),
                new LottoNumberValidate(4),
                new LottoNumberValidate(5),
                new LottoNumberValidate(6)));
        BonusBall bonusBall = new BonusBall(new LottoNumberValidate(20));
        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoNumbers, bonusBall);

        Lottos lottos = new Lottos(List.of(
                new Lotto(Set.of(1, 2, 35, 29, 9, 11)),
                new Lotto(Set.of(1, 3, 16, 29, 9, 11)),
                new Lotto(Set.of(1, 2, 3, 4, 5, 20))
        ));

        Lottery lottery = new Lottery(winnerNumbers, lottos);
        //then
        assertThat(lottery.getInvestment()).isEqualTo(10000.0);
    }
}