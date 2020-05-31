package com.lotto.domain;

import com.lotto.view.LottoView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoMachineTest {

    @DisplayName("로또 구매 : 랜던 값 추출 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 3, 5 })
    void buyLottoTest(final Integer countOfLotto) {
        LottoMachine lottoMachine = new LottoMachine(new TestLottoView(countOfLotto, 0));
        lottoMachine.setLottoExtractor(new TestLottoExtractor());
        List<Lotto> extractedLotto = lottoMachine.buyLotto();
        assertEquals(extractedLotto.size(), countOfLotto);
    }

    @DisplayName("로또 구매 : 수동으로 선택한 값이 구매 가격을 초과한 경우")
    @ParameterizedTest
    @MethodSource("provideManualLottoCount")
    void buyLottoIllegalArgumentExceptionTest(final Integer countOfAutomaticLotto, final Integer countOfManualLotto) {
        LottoMachine lottoMachine = new LottoMachine(new TestLottoView(countOfAutomaticLotto, countOfManualLotto));
        lottoMachine.setLottoExtractor(new TestLottoExtractor());

        assertThatThrownBy(lottoMachine::buyLotto)
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideManualLottoCount() {
        return Stream.of(
                Arguments.of(5, 6),
                Arguments.of(14, 18)
        );
    }

    private static class TestLottoExtractor extends ShuffleLottoExtractor {

        @Override
        public List<Integer> extractLottoNumbers(List<Integer> availableLottoNumbers) {
            return Arrays.asList(1, 2, 3, 4, 5, 6);
        }
    }

    private static class TestLottoView extends LottoView {

        private Integer countOfLotto;
        private Integer countOfManualLotto;

        TestLottoView(Integer countOfLotto, Integer countOfManualLotto) {
            this.countOfLotto = countOfLotto;
            this.countOfManualLotto = countOfManualLotto;
        }

        @Override
        public Integer inputPurchaseAmountOfLotto() {
            return this.countOfLotto;
        }

        @Override
        public Integer inputCountOfManualLotto() {
            return this.countOfManualLotto;
        }

        @Override
        public void outputManualLottoMessage() {

        }

        @Override
        public void outputResultOfEachLottoCount(Integer countOfAutomaticLotto, Integer countOfManualLotto) {

        }

        @Override
        public void outputExtractedLotto(List<Lotto> lotto) {

        }
    }
}
