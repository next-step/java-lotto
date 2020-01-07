package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShopTest {

    @Test
    void 판매했을_떄_로또_개수가_정확히_나오는지_확인한다() {
        assertThat(LottoShop.order(
                Order.builder()
                        .payment(20000)
                        .selfNumber(Collections.singletonList("1,2,3,4,5,6"))
                        .build())
                .getLottosCount())
                .isEqualTo(20);

    }
}
