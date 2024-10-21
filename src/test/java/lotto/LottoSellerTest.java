package lotto;

import lotto.service.LottoSeller;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoSellerTest {

    @Test
    public void 로또_판매() {
        List<Integer> lotto = LottoSeller.sellLotto();

        for (int count = 0; count <= 6; count++) {
            lotto.forEach(number -> {
                assertThat(number).isGreaterThanOrEqualTo(1);
                assertThat(number).isLessThanOrEqualTo(45);
            });
        }
    }
}
