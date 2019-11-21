package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 02:18
 */
public class LottoPurchaseTest {
    @Test
    void 생성() {
        LottoPurchase amount = new LottoPurchase(new LottoAmount(10000));
        assertThat(amount).isEqualTo(new LottoPurchase(new LottoAmount(10000)));
    }

    @Test
    void 구매금액에_따른_로또_개수_구하기() {
        LottoPurchase lottoAmount = new LottoPurchase(new LottoAmount(10000));
        assertThat(lottoAmount.getAutoLottoCount()).isEqualTo(10);
    }
}
