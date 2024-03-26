package lotto;

import lotto.domain.*;
import lotto.utils.TestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {

    private final LottoSeller mockLottoSeller = new LottoSeller(new TestNumberGenerator(List.of(1, 2, 3, 4, 5, 6)));

    @ParameterizedTest
    @DisplayName("로또 구매 테스트")
    @CsvSource(value = {"14000,14", "4000,4", "1000,1"}, delimiter = ',')
    void testPurchaseLotto(int price, int expected) {
        User user = new User();
        user.purchaseLottos(mockLottoSeller, price);
        assertThat(user.getLottos()).hasSize(expected);
    }

    @ParameterizedTest
    @DisplayName("올바르지 않은 가격으로 로또 살 때 테스트")
    @ValueSource(ints = {100, 1200, 12300})
    void testInvalidPurchase(int price) {
        User user = new User();
        assertThatIllegalArgumentException().isThrownBy(() -> user.purchaseLottos(mockLottoSeller, price));
    }

    @ParameterizedTest
    @DisplayName("로또 수익률 및 결과 테스트")
    @MethodSource("getLottosAndRateOfReturn")
    void testRateOfReturn(WinningLotto winningLotto, int price, double expectedRateOfReturn, Map<LottoWinningRank, Integer> expectedLottoResultCount) {
        User user = new User();
        user.purchaseLottos(mockLottoSeller, price);
        UserLottoResult userLottoResult = user.getUserLottoResult(winningLotto);

        assertThat(userLottoResult.getRateOfReturn()).isEqualTo(expectedRateOfReturn);

        for (Map.Entry<LottoWinningRank, Integer> lottoResultCount : expectedLottoResultCount.entrySet()) {
            assertThat(userLottoResult.getCountLottoResult(lottoResultCount.getKey())).isEqualTo(lottoResultCount.getValue());
        }

    }

    @Test
    @DisplayName("로또 여러 번 구매 가능한 지 테스트")
    void testPurchaseManyTimes() {
        User user = new User();
        int purchaseCount = 2;
        int price  = purchaseCount * Lotto.PRICE;
        int time = 3;

        for (int i = 0; i < time; i++) {
            user.purchaseLottos(mockLottoSeller, price);
        }

        assertThat(user.getLottos()).hasSize(time * purchaseCount);
        assertThat(user.getPurchasePrice()).isEqualTo(price * time);
    }

    private static Stream<Arguments> getLottosAndRateOfReturn() {
        return Stream.of(
                Arguments.of(new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 8), 4000, 2000000.0, getLottoResultMap(4, 0, 0, 0, 0)),
                Arguments.of(new WinningLotto(List.of(2, 3, 4, 5, 6, 7), 1), 5000, 30000, getLottoResultMap(0, 5, 0, 0, 0)),
                Arguments.of(new WinningLotto(List.of(2, 3, 4, 5, 6, 7), 8), 5000, 1500, getLottoResultMap(0, 0, 5, 0, 0)),
                Arguments.of(new WinningLotto(List.of(3, 4, 5, 6, 7, 8), 10), 6000, 50.0, getLottoResultMap(0, 0, 0, 6, 0)),
                Arguments.of(new WinningLotto(List.of(4, 5, 6, 7, 8, 9), 10), 3000, 5.0, getLottoResultMap(0, 0, 0, 0,3 )),
                Arguments.of(new WinningLotto(List.of(5, 6, 7, 8, 9, 10), 11), 4000, 0.0, getLottoResultMap(0, 0, 0, 0, 0))

        );
    }

    private static Map<LottoWinningRank, Integer> getLottoResultMap(int first, int second, int third, int fourth, int fifth) {
        Map<LottoWinningRank, Integer> map = new EnumMap<>(LottoWinningRank.class);
        map.put(LottoWinningRank.FIRST, first);
        map.put(LottoWinningRank.SECOND, second);
        map.put(LottoWinningRank.THIRD, third);
        map.put(LottoWinningRank.FOURTH, fourth);
        map.put(LottoWinningRank.FIFTH, fifth);

        return map;
    }
}
