package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("가격만큼의 로또를 구매")
    @Test
    void 로또_구매() {
        Lottos lottos = new Lottos(14000);
        assertThat(lottos.getLottos().size()).isEqualTo(14000 / Lotto.LOTTO_PRICE);
    }

    @DisplayName("로또 총 당첨 금액을 리턴한다.")
    @Test
    void 총_당첨_금액() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("2, 3,4,5, 6,30"),//1500000
                new Lotto("1, 2,3,4, 5,6"),//2000000000
                new Lotto("1, 5,6,9, 30,40"),//5000
                new Lotto("3, 4,5,6, 15,32")//50000
        ));

        assertThat(lottos.totalWinningAmount("1,2,3,4,5,6")).isEqualTo(2001555000);
    }
    @DisplayName("당첨금액/구매금액 값을 소숫점 2자리까지 표현한 값을 리턴")
    @Test
    void 수익률() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("2, 3,4,5, 6,30"),//1500000
                new Lotto("1, 2,3,4, 5,6"),//2000000000
                new Lotto("1, 5,6,9, 30,40"),//5000
                new Lotto("3, 4,5,6, 15,32")//50000
        ));
        assertThat(lottos.rateOfReturn("1,2,3,4,5,6")).isEqualTo(new BigDecimal(500388.75));
    }

    @DisplayName("당첨번호와 당첨번호 포함 갯수를 전달하면 일치하는 로또의 갯수를 리턴")
    @ParameterizedTest
    @CsvSource(value = {"6:1", "5:1", "4:1", "3:4"}, delimiter = ':')
    void 당첨_개수(int correctCount, int expectedWinningCount) {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("2, 3,4,5, 6,30"),//1500000
                new Lotto("1, 2,3,4, 5,6"),//2000000000
                new Lotto("1, 5,6,9, 30,40"),//5000
                new Lotto("3, 4,5,6, 15,32"),//50000
                new Lotto("4, 5,6,9, 30,40"),//5000
                new Lotto("2, 5,6,9, 30,40"),//5000
                new Lotto("1, 2,3,9, 30,40")//5000
        ));
        assertThat(lottos.winningCount("1,2,3,4,5,6", correctCount)).isEqualTo(expectedWinningCount);
    }
}