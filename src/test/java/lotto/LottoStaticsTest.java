package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStaticsTest {

    Lottos lottos;

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_COUNT = 10;

    @Test
    void getProfitRatio() {
        List<Number> winningList = Number.createNumberList(List.of(1,2,3,4,5,6));
        List<Number> balls = Number.createNumberList(List.of(1,2,3,4,11,10));

        Number lottoBonusNumber = new Number(7);

        lottos = new Lottos(LOTTO_COUNT * LOTTO_PRICE, LOTTO_PRICE, new LottoBallPolicy(balls));
        LottoStatics lottoStatics = new LottoStatics(WinnigLotto.createLotto(winningList, lottoBonusNumber), lottos);

        var actual = lottoStatics.getProfitRatio();
        var expect = 50.0 ;

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void getProfitRatio_보너스번호() {
        List<Number> winningList = Number.createNumberList(List.of(1,2,3,4,5,6));
        List<Number> balls = Number.createNumberList(List.of(1,2,3,4,11,10));

        Number lottoBonusNumber = new Number(10);

        lottos = new Lottos(LOTTO_COUNT * LOTTO_PRICE, LOTTO_PRICE, new LottoBallPolicy(balls));
        LottoStatics lottoStatics = new LottoStatics(WinnigLotto.createLotto(winningList, lottoBonusNumber), lottos);

        var actual = lottoStatics.getProfitRatio();
        var expect = 30500.0 ;

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void getNumberCount() {
        List<Number> winningList = Number.createNumberList(List.of(1,2,3,4,5,6));
        List<Number> balls = Number.createNumberList(List.of(1,2,3,4,11,10));

        LottoBallPolicy lottoBallPolicy = new LottoBallPolicy(balls);
        lottos = new Lottos(LOTTO_COUNT * LOTTO_PRICE, LOTTO_PRICE, lottoBallPolicy);

        Number lottoBonusNumber = new Number(7);

        LottoStatics lottoStatics = new LottoStatics(WinnigLotto.createLotto(winningList, lottoBonusNumber), lottos);

        var actual = lottoStatics.getNumberCount(LottoPricePolicy.FOURTH);
        var expect = 10;

        assertThat(actual).isEqualTo(expect);
    }
}
