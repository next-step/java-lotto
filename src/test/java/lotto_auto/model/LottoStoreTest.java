package lotto_auto.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    private LottoStore lottoStore;

    @BeforeEach
    public void test() {
        lottoStore = new LottoStore();
    }

    @DisplayName("LottoBundle 생성 테스트")
    @Test
    public void returnLottoBundleTest() {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(LottoNumbers.generate());
        lottoNumbersList.add(LottoNumbers.generate());
        lottoNumbersList.add(LottoNumbers.generate());
        lottoNumbersList.add(LottoNumbers.generate());
        lottoNumbersList.add(LottoNumbers.generate());
        Order order = new Order( lottoNumbersList, 5);
        LottoBundle lottoBundle = lottoStore.sell(order);
        assertThat(lottoBundle).isNotNull();
    }

}
