package lotto;

import lotto.model.Lottos;
import lotto.service.LottoSeller;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoSellerTest {

    private static final LottoSeller lottoSeller = new LottoSeller();

    @Test
    public void 로또_판매() {
        lottoSeller.sellLottos(14);

        Map<Integer, List<Integer>> lottos = lottoSeller.provideLottos();
        int size = lottos.size();

        assertThat(size).isEqualTo(14);

        for (int count = 1; count <= size; count++) {
            List<Integer> lotto = lottos.get(count);

            lotto.forEach(number -> {
                assertThat(number).isGreaterThanOrEqualTo(1);
                assertThat(number).isLessThanOrEqualTo(45);
            });
        }
    }
}
