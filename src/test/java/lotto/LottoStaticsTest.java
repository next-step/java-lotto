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
        lottoStatics = new LottoStatics();
    }

    @Test
    void getProfitRatio() {
        List<Number> winningList = Number.createNumberList(List.of(1,2,3,4,5,6));
        List<Number> balls = Number.createNumberList(List.of(1,2,3,4,11,10));

        lottos = new Lottos(LOTTO_COUNT, new LottoBallPolicy(balls), LOTTO_PRICE);

        var actual = lottoStatics.getProfitRatio(Lotto.createLotto(winningList, LOTTO_PRICE), lottos);
        var expect = "50.0" ;

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void getNumberCount() {
        List<Number> winningList = Number.createNumberList(List.of(1,2,3,4,5,6));
        List<Number> balls = Number.createNumberList(List.of(1,2,3,4,11,10));

        LottoBallPolicy lottoBallPolicy = new LottoBallPolicy(balls);
        lottos = new Lottos(LOTTO_COUNT, lottoBallPolicy, LOTTO_PRICE);
        lottoStatics.calculateProfitStatistics(Lotto.createLotto(winningList, LOTTO_PRICE), lottos);

        var actual = lottoStatics.getNumberCount(Number.createNumber(4));
        var expect = 10;

        assertThat(actual).isEqualTo(expect);
    }
}
