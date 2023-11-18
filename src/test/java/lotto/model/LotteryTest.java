package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {
    WinnerNumbers winnerNumbers;
    Lottos lottos;
    Lottery lottery;

    @BeforeEach
    void setUp() {
        winnerNumbers = new WinnerNumbers(Set.of(
                new PositiveNumber(1),
                new PositiveNumber(2),
                new PositiveNumber(3),
                new PositiveNumber(4),
                new PositiveNumber(5),
                new PositiveNumber(6)));
        lottos = new Lottos(List.of(
                new Lotto(Set.of(1, 3, 5, 7, 9, 11)),
                new Lotto(Set.of(1, 2, 3, 4, 9, 11))
        ));
        lottery = new Lottery(winnerNumbers, lottos);
    }

    @Test
    @DisplayName("등수에 따른 당첨금을 총합해서 보여준다.")
    void test1() throws Exception {
        assertThat(lottery.depositTotalMoney()).isEqualTo(55000);
    }

    @Test
    @DisplayName("구입금액과 당첨금에 따른 수입률을 보여준다")
    void test2() throws Exception {
        assertThat(lottery.getInvestment()).isEqualTo(27.5);
    }

    @Test
    @DisplayName("전체 로또가 당첨 번호와 몇개 맞는지 리턴한다.")
    void test3() throws Exception {
        assertThat(lottery.checkForWin(3)).isEqualTo(1);
        assertThat(lottery.checkForWin(4)).isEqualTo(1);
        assertThat(lottery.checkForWin(5)).isEqualTo(0);
    }
}