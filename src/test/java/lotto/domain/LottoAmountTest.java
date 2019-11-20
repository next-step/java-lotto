package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-20 20:44
 */
public class LottoAmountTest {
    @Test
    void 객체_생성() {
        LottoAmount lottoAmount = new LottoAmount(10000);
        assertThat(lottoAmount).isEqualTo(lottoAmount);
    }

    @Test
    void 최소값_검증() {
        assertThatThrownBy(() -> new LottoAmount(500)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_갯수_구하기() {
        LottoAmount lottoAmount = new LottoAmount(10000);
        assertThat(lottoAmount.getAvailableLottoCount()).isEqualTo(10);
    }

    @Test
    void 로또_구매금액_감소() {
        LottoAmount lottoAmount = new LottoAmount(10000);
        lottoAmount.decrease();
        assertThat(lottoAmount.getAvailableLottoCount()).isEqualTo(9);
    }

    @Test
    void 구매금액_0원_테스트() {
        LottoAmount lottoAmount = new LottoAmount(1000);
        lottoAmount.decrease();
        assertThat(lottoAmount.isEnd()).isTrue();
    }
}
