package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {
    WinnerNumbers winnerNumbers;
    LottoNumbers lottoNumbers;
    BonusBall bonusBall;
    Lottos lottos;
    Lottery lottery;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers(Set.of(
                new LottoNumberValidate(1),
                new LottoNumberValidate(2),
                new LottoNumberValidate(3),
                new LottoNumberValidate(4),
                new LottoNumberValidate(5),
                new LottoNumberValidate(6)));
        bonusBall = new BonusBall(new LottoNumberValidate(20));
        winnerNumbers = new WinnerNumbers(lottoNumbers, bonusBall);
        lottos = new Lottos(List.of(
                new Lotto(Set.of(1, 2, 35, 29, 9, 11)),
                new Lotto(Set.of(1, 3, 16, 29, 9, 11)),
                new Lotto(Set.of(1, 2, 3, 4, 5, 20))
        ));
        lottery = new Lottery(winnerNumbers, lottos);
    }

    @Test
    @DisplayName("등수에 따른 당첨금을 총합해서 보여준다.")
    void test1() throws Exception {
        assertThat(lottery.depositTotalMoney()).isEqualTo(30000000L);
    }

    @Test
    @DisplayName("구입금액과 당첨금에 따른 수입률을 보여준다")
    void test2() throws Exception {
        assertThat(lottery.getInvestment()).isEqualTo(10000.0);
    }

    @Test
    @DisplayName("전체 로또가 당첨 번호와 몇개 맞는지 리턴한다.")
    void test3() throws Exception {
//        assertThat(lottery.checkForWin(5, true)).isEqualTo(1);
//        assertThat(lottery.checkForWin(3, false)).isEqualTo(0);
//        assertThat(lottery.checkForWin(4, false)).isEqualTo(0);
    }
}