package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-21 00:08
 */
public class LottosTest {
    @Test
    void 생성() {
        List<String> lottoNumber = new ArrayList<>();
        lottoNumber.add("1,2,3,4,5,6");
        lottoNumber.add("2,3,4,7,5,6");
        LottoPurchase lottoPurchase = new LottoPurchase(new LottoAmount(2000), 2);
        Lottos lottos = new Lottos(lottoPurchase, lottoNumber);
        assertThat(lottos).isEqualTo(new Lottos(new LottoPurchase(new LottoAmount(2000), 2), lottoNumber));
    }

    @Test
    void 발급() {
        List<String> lottoNumber = new ArrayList<>();
        lottoNumber.add("1,2,3,4,5,6");
        lottoNumber.add("2,3,4,7,5,6");
        LottoPurchase lottoPurchase = new LottoPurchase(new LottoAmount(2000), 2);
        Lottos lottos = new Lottos(lottoPurchase, lottoNumber);
        List<Lotto> target = Arrays.asList(Lotto.of(Arrays.asList(1,2,3,4,5,6)), Lotto.of(Arrays.asList(2,3,4,7,5,6)));
        assertThat(lottos.getLottoNumbers()).containsAll(target);
    }
}
