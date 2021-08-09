package step2.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.LottoTestHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {

    @ParameterizedTest
    @DisplayName("로또 가격을 테스트 한다")
    @CsvSource(value = {"1,1000", "5,5000", "15,15000"})
    public void priceTest(int lottoCount, int expectedPrice) {
        Lottos lottos = LottoTestHelper.generateLottos(lottoCount);
        assertEquals(expectedPrice, lottos.price());
    }

    @ParameterizedTest
    @DisplayName("로또 갯수를 테스트 한다")
    @CsvSource(value = {"1,1", "5,5", "15,15"})
    public void countTest(int lottoCount, int expectedCount) {
        Lottos lottos = LottoTestHelper.generateLottos(lottoCount);
        assertEquals(expectedCount, lottos.count());
    }
}