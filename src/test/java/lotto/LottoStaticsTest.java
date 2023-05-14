package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStaticsTest {

    LottoStatics lottoStatics;

    Lottos lottos;

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_COUNT = 10;

    @BeforeEach
    public void init() {
        lottoStatics = new LottoStatics(LOTTO_PRICE * LOTTO_COUNT, LOTTO_PRICE);
    }

    @Test
    void getProfitRatio() {
        List<Number> winningList = List.of(Number.createNumber(1), Number.createNumber(2), Number.createNumber(3), Number.createNumber(4), Number.createNumber(5), Number.createNumber(6));
        List<Number> balls = List.of(Number.createNumber(1), Number.createNumber(2), Number.createNumber(3), Number.createNumber(4), Number.createNumber(11), Number.createNumber(10));

        lottos = new Lottos(LOTTO_COUNT);
        lottos.shuffleLottos(new LottoBalls(balls));

        var actual = lottoStatics.getProfitRatio(winningList, lottos.getLottoList());
        var expect = "50.0" ;

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void getNumberCount() {
        List<Number> winningList = List.of(Number.createNumber(1), Number.createNumber(2), Number.createNumber(3), Number.createNumber(4), Number.createNumber(5), Number.createNumber(6));
        List<Number> balls = List.of(Number.createNumber(1), Number.createNumber(2), Number.createNumber(3), Number.createNumber(4), Number.createNumber(11), Number.createNumber(10));

        lottos = new Lottos(LOTTO_COUNT);
        lottos.shuffleLottos(new LottoBalls(balls));
        lottoStatics.calculateProfitStatistics(winningList, lottos.getLottoList());

        var actual = lottoStatics.getNumberCount(Number.createNumber(4));
        var expect = 10;

        assertThat(actual).isEqualTo(expect);
    }
}
