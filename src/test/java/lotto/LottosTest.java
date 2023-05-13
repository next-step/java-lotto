package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    Lottos lottos;

    @BeforeEach
    public void init(){
        lottos = new Lottos(14000);
    }


    @Test
    void makeLottos() {
        lottos = new Lottos(10000);
        lottos.makeLottos();

        var actualSize = lottos.getLottoList().size();
        var expectSize = 10;

        assertThat(actualSize).isEqualTo(expectSize);
    }


    @Test
    void getProfitRatio() {
        List<Number> winningList = List.of(Number.createNumber(1), Number.createNumber(2), Number.createNumber(3), Number.createNumber(4), Number.createNumber(5), Number.createNumber(6));
        List<Number> balls = List.of(Number.createNumber(1), Number.createNumber(2), Number.createNumber(3), Number.createNumber(4), Number.createNumber(11), Number.createNumber(10));

        lottos = new Lottos(5000);
        lottos.makeLottos();
        lottos.shuffleLottos(new LottoBalls(balls));

        var actual = lottos.getProfitRatio(winningList);
        var expect = "50.0";

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void getNumberCount() {
        List<Number> winningList = List.of(Number.createNumber(1), Number.createNumber(2), Number.createNumber(3), Number.createNumber(4), Number.createNumber(5), Number.createNumber(6));
        List<Number> balls = List.of(Number.createNumber(1), Number.createNumber(2), Number.createNumber(3), Number.createNumber(4), Number.createNumber(11), Number.createNumber(10));

        lottos = new Lottos(10000);
        lottos.makeLottos();
        lottos.shuffleLottos(new LottoBalls(balls));
        lottos.calculateProfitStatistics(winningList);

        var actual = lottos.getNumberCount(Number.createNumber(4));
        var expect = 10;

        assertThat(actual).isEqualTo(expect);
    }

}
