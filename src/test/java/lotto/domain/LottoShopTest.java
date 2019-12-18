package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    @Test
    void 판매했을_떄_로또_개수가_정확히_나오는지_확인한다() {
        assertThat(new LottoShop().sell(14000).size()).isEqualTo(14);
    }
}
