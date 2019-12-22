package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    @Test
    void 판매했을_떄_로또_개수가_정확히_나오는지_확인한다() {
        assertThat(LottoShop.order(new Order.Builder().payment(20000).selfNumber(Arrays.asList("1,2,3,4,5,6")).build()).size()).isEqualTo(20);
    }
}
