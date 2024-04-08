package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductTest {
    @Test
    @DisplayName("제품 가져오기 테스트")
    public void getProductTest() {
        Product lotto = Product.getProduct("Lotto");

        assertThat(lotto).isEqualTo(Product.LOTTO);
    }

    @Test
    @DisplayName("잘못된 제품명 가져오기 오류 테스트")
    public void invalidProductName() {
        assertThatThrownBy(() -> Product.getProduct("로또"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_FOUND_PRODUCT.getMessage());
    }
}
