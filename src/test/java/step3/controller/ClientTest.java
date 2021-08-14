package step3.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.LottoTestHelper;
import step3.lotto.*;
import step3.lotto.client.Client;
import step3.lotto.exception.NotEnoughMoneyException;
import step3.lotto.result.ResultStatistic;

import java.util.Arrays;
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
    @CsvSource("1000,1,2000000000")
    void calculateResultStatisticTest(long money, int expectedCountOfRank, long expectedPrizeMoney) {
        Client client = setUpClient(money);

        TotalLottoNumber totalLottoNumber = LottoTestHelper.generateTotalLottoNumber();
        ResultStatistic resultStatistic = client.calculateResultStatistic(totalLottoNumber);

        assertEquals(expectedCountOfRank, resultStatistic.countOfRank(Rank.FIRST));
        long actualPrize = Rank.FIRST.getPrizeMoney();
        assertEquals(expectedPrizeMoney, actualPrize);
    }

    private Client setUpClient(long money) {
        Client client = new Client(money);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lottos lottos = LottoTestHelper.generateFixedNumberLottos(numbers);
        client.buyLotto(lottos);
        return client;
    }

}