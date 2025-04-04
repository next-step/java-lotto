package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SellerTest {
    @DisplayName("로또 판매점을 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(new Seller(14000, 3)).isNotNull();
    }

    @DisplayName("투입 금액 보다 수동 구입 개수가 많을 시 예외를 발생한다.")
    @Test
    void invalidTest() {
        assertThatThrownBy(() -> new Seller(10000, 11)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 로또 구입 개수가 투입 금액보다 많습니다.");
    }

    @DisplayName("수동 로또를 생성한다.")
    @Test
    void generateManualTest() {
        Seller seller = new Seller(10000, 3);
        List<String> manualLottoNumbers = List.of("1, 2, 3, 4, 5, 6");
        List<Lotto> lottos = seller.generateManual(manualLottoNumbers);
        assertThat(lottos).hasSize(1);
    }

    @DisplayName("입력받은 금액에 해당하는 로또를 생성한다.")
    @Test
    void generateAutoTest() {
        Seller seller = new Seller(10000, 3);
        assertThat(seller.generateAuto()).hasSize(10);
    }

}
