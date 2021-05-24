package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName("로또 한장을 테스트코드로 구매하여 일치 갯수 조회 테스트")
    @Test
    void countLottosCollectNumber_테스트코드로_구매_로또_일치_번호_테스트() {
        LottoBuy lottoBuy = new LottoBuy();
        Lottos lottos = lottoBuy.buyOneRandomLotto(() -> new LottoNumber(Arrays.asList(1, 3, 4, 5, 6, 7)));
        assertThat(lottos.isCount(1)).isTrue();

        Lotto winLotto = new Lotto(() -> new LottoNumber(Arrays.asList(1, 3, 4, 5, 6, 8)));
        LottoResult lottoResult = lottos.compareWinNumber(winLotto);
        assertThat(lottoResult.isFourth(0)).isTrue();
    }
}
