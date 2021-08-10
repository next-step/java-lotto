package step2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.LottoTestHelper;
import step2.lotto.*;
import step2.lotto.client.Client;
import step2.lotto.exception.NotEnoughMoneyException;
import step2.lotto.result.ResultStatistic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @ParameterizedTest
    @DisplayName("구매할 수 있는 로또 갯수 테스트")
    @CsvSource(value = {"0,0", "1000,1", "15000,15"})
    void buyableLottoCountTest(int money, long expectedBuyableLottoCount) {
        Client client = new Client(money);
        long acutalBuyableLottoCount = client.buyableLottoCount();

        assertEquals(expectedBuyableLottoCount, acutalBuyableLottoCount);
    }

    @ParameterizedTest
    @DisplayName("로또 구매 테스트")
    @ValueSource(longs = {1000, 2000, 5000, 10000})
    void buyLottoTest(long money) {
        Client client = new Client(money);
        long buyableLottoCount = client.buyableLottoCount();
        assertDoesNotThrow(() -> client.buyLotto(LottoTestHelper.generateLottos(buyableLottoCount)));
    }

    @ParameterizedTest
    @DisplayName("가진 금액보다 많은 금액의 로또를 사려고 하면 익셉션이 발생한다")
    @ValueSource(ints = {1000, 2000, 5000, 10000})
    void NotEnoughMoneyExceptionTest(long money) {
        Client client = new Client(money);
        long buyableLottoCount = client.buyableLottoCount();
        assertThrows(NotEnoughMoneyException.class, () -> {
            long overLimitCount = buyableLottoCount + 1;
            client.buyLotto(LottoTestHelper.generateLottos(overLimitCount));
        });
    }

    @ParameterizedTest
    @DisplayName("로또 결과 확인 테스트")
    @CsvSource("1000,'1,2,3,4,5,6',6,2000000000")
    void calculateResultStatisticTest(int money, String input, long expectedMatchesOfNumber, int expectedPrize) {
        Client client = new Client(money);

        List<Integer> numbers = LottoTestHelper.toIntegerList(input);
        LottoNumber winningNumber = new LottoNumber(numbers);

        Lottos lottos = LottoTestHelper.generateFixedNumberLottos(numbers);
        int boughtLottoCount = lottos.count();

        client.buyLotto(lottos);
        ResultStatistic resultStatistic = client.calculateResultStatistic(winningNumber);

        assertEquals(boughtLottoCount, resultStatistic.countOfMatches(expectedMatchesOfNumber));
        long actualPrize = LottoPrize.getLottoPrize(expectedMatchesOfNumber).getPrizeMoney();
        assertEquals(expectedPrize, actualPrize);
    }

}