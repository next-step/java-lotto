package lottogame.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import lottogame.model.lotto.ManualLottos;
import lottogame.model.price.LottoPurchasePrice;
import org.junit.jupiter.api.Test;

class LottoPurchaseRequestTest {

    @Test
    void 자동로또의_갯수를_계산할_수_있다() {
        List<Set<Integer>> manualList = List.of(
                Set.of(1, 2, 3, 4, 5, 6)
        );

        LottoPurchaseRequest lottoPurchaseRequest = new LottoPurchaseRequest(
                new LottoPurchasePrice(10000),
                new ManualLottos(manualList)
        );

        assertThat(
                lottoPurchaseRequest.calculateAutoLottoCount(1000)
        ).isEqualTo(9);
    }
}