package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 02:18
 */
public class LottoAmountTest {
    @Test
    void 생성() {
        LottoAmount amount = LottoAmount.of(10000);
        assertThat(amount).isEqualTo(LottoAmount.of(10000));
    }

    @Test
    void 구매금액에_따른_로또_개수_구하기() {
        LottoAmount lottoAmount = LottoAmount.of(10000);
        assertThat(lottoAmount.getAutoLottoCount()).isEqualTo(10);
    }

    @Test
    void 최소금액_검증() {
        assertThatThrownBy(() -> {
            LottoAmount.of(500);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void is_end_test() {
        LottoAmount lottoAmount = LottoAmount.of(2000);
        lottoAmount = lottoAmount.decrease();
        assertThat(!lottoAmount.isEndAutoLotto()).isTrue();
    }
}
