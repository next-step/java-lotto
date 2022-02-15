package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PriceTest {
    @Test
    void 수동개수에_따라_자동로또_개수를_계산한다(){
        Price price = new Price(5000);
        int manualLottoCount=2;
        Count autoLottoCount= price.calculateCount(manualLottoCount);
        assertThat(autoLottoCount.getAutoLottoCount()).isEqualTo(3);
    }
}