package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SellerTest {
    @DisplayName("로또 판매점을 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(new Seller(14000)).isNotNull();
    }

    @DisplayName("입력받은 금액에 해당하는 로또를 생성한다.")
    @Test
    void generateLottosTest() {
        Seller seller = new Seller(10000, Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6"));
        List<Lotto> lottos = seller.generateLottos();
        assertThat(lottos).hasSize(10);
    }

}
