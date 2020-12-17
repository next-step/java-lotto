package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottosTest {

    private WinningLottos winningLottos;
    @BeforeEach
    void setup() {
        winningLottos = new WinningLottos();
    }

    @Test
    void getMatchNumber() {
        int matchingNumberOfCount = winningLottos.addMatchingNumber(3);
        assertThat(matchingNumberOfCount).isEqualTo( 1);
    }

    @Test
    void calculateLottoMoney(){
        winningLottos.addMatchingNumber(3);
        winningLottos.addMatchingNumber(4);
        winningLottos.addMatchingNumber(5);
        winningLottos.addMatchingNumber(6);
        assertThat(winningLottos.amountOfWinning()).isEqualTo(2001555000);
    }

    @Test
    void winningNumberCountCheck(){
        winningLottos.addMatchingNumber(3);
        int matchingNumberOfCount = winningLottos.addMatchingNumber(3);
        assertThat(matchingNumberOfCount).isEqualTo(2);
        assertThat(winningLottos.getNumberOfMatchFour()).isEqualTo(0);
    }
    @Test
    void winningRevenueTest(){
        winningLottos.addMatchingNumber(3);
        float revenue = winningLottos.calcurateRevenue("1000");
        assertThat(revenue).isEqualTo(5);
    }

    @Test
    void cal(){
        float a = 100;
        float b = 20;
        System.out.println(b/a);
    }

}