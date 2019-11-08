package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 02:18
 */
public class LottoAmountTest {
    @Test
    void 생성() {
        LottoAmount amount = new LottoAmount(10000);
        assertThat(amount).isEqualTo(new LottoAmount(10000));
    }

    @Test
    void 구매금액에_따른_로또_개수_구하기() {
        LottoAmount lottoAmount = new LottoAmount(10000);
        assertThat(lottoAmount.amount()).isEqualTo(10);
    }
}
