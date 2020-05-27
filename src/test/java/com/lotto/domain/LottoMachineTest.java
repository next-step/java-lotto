package com.lotto.domain;

import com.lotto.view.LottoView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoMachineTest {

    @DisplayName("로또 구매 : 랜던 값 추출 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    void buyLottoTest(final Integer countOfLotto) {
        LottoMachine lottoMachine = new LottoMachine(new TestLottoExtractor(), new TestLottoView(countOfLotto));
        List<Lotto> extractedLotto = lottoMachine.buyLotto();
        assertEquals(extractedLotto.size(), countOfLotto);
    }

    private static class TestLottoExtractor extends ShuffleLottoExtractor {

        @Override
        public List<Integer> extractLottoNumbers(List<Integer> availableLottoNumbers) {
            return Arrays.asList(1, 2, 3, 4, 5, 6);
        }
    }

    private static class TestLottoView extends LottoView {

        private Integer count;

        TestLottoView(Integer count) {
            this.count = count;
        }

        @Override
        public Integer inputPurchaseAmountOfLotto() {
            return count;
        }

        @Override
        public void outputExtractedLotto(List<Lotto> lotto) {

        }
    }
}
