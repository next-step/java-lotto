package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("테스트 로또를 구매하여 4등 ( 3개 일치 ) 갯수 조회 테스트")
    @Test
    void countFourth_4등_갯수_조회() {
        LottoBuy lottoBuy = new LottoBuy();
        Lottos lottos = lottoBuy.buyOneRandomLotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoResult lottoResult = lottos.compareWinNumber(Arrays.asList(1, 2, 3, 8, 9, 10));
        assertThat(lottoResult.isFourth(1)).isTrue();
    }
}
