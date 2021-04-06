package step4.domain.shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoShopTest {

    @DisplayName("LottoShop 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        LottoShop lottoShop = LottoShop.getInstance();

        // then
        assertThat(lottoShop).isNotNull();
    }
}