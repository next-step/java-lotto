package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class LottoPriceTest {

    @Test
    void 생성() {
        LottoPrice lottoPrice = new LottoPrice(100000, 0);
        assertThat(lottoPrice).isEqualTo(new LottoPrice(100000, 0));
    }

    @Test
    void 천원_이하_생성시_오류() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoPrice(900, 0));
    }

    @Test
    void 천원단위가_아닐경우_오류() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoPrice(13340, 0));
    }

    @Test
    void 수동_로또_생성() {
        LottoPrice lottoPrice = new LottoPrice(10000, 3);
        assertThat(lottoPrice).isEqualTo(new LottoPrice(10000, 3));
    }

}