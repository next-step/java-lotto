package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("테스트 로또를 구매하여 4등 ( 3개 일치 ) 갯수 조회 테스트")
    @Test
    void countFourth_4등_갯수_조회() {
        LottoBuy lottoBuy = new LottoBuy();
        Lottos lottos = lottoBuy.buyOneRandomLotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoResult lottoResult = lottos.compareWinNumber(new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 8, 9, 10))));
        assertThat(lottoResult.isFourth(1)).isTrue();
    }

    @DisplayName("테스트 로또를 여러장 구매하여 각 등수 갯수 조회 테스트")
    @Test
    void countManyLottoRank_여러장_등수_조회() {
        Lottos lottos = new Lottos(new ArrayList<Lotto>(Arrays.asList(
                new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7))),
                new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8))),
                new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8))))
        ));
        Lotto winLottto = new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoResult lottoResult = lottos.compareWinNumber(winLottto);
        assertThat(lottoResult.isFirst(1)).isTrue();
        assertThat(lottoResult.isSecond(1)).isTrue();
        assertThat(lottoResult.isThird(2)).isTrue();
        assertThat(lottoResult.isFourth(0)).isTrue();
    }

    @DisplayName("수익률 테스트")
    @Test
    void lottoProfit_수익률_테스트() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.checkRank(3);
        double result = lottoResult.calculateProfit(14);
        assertThat(result).isEqualTo(0.35);
    }
}
