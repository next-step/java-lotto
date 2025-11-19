package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class LottoPriceTest {

    @Test
    void 생성(){
        LottoPrice lottoPrice = new LottoPrice(100000);
        Assertions.assertThat(lottoPrice).isEqualTo(new LottoPrice(100000, 100));
    }

    @Test
    void 천원_이하_생성시_오류(){
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new LottoPrice(900));
    }

    @Test
    void 천원단위가_아닐경우_오류(){
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new LottoPrice(13340));
    }

}