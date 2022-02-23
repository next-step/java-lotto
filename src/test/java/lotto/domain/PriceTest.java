package lotto.domain;

import static org.assertj.core.api.BDDAssumptions.given;

import org.junit.jupiter.api.Test;

class PriceTest {
    @Test
    void 로또구매수량계산(){
        Price price = new Price(14000);

        given(price.countBuySum()).isEqualTo(14);
    }
}
