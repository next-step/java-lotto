package edu.nextstep.camp.lotto.domain;


import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PurchaseListTest {
    @ParameterizedTest(name = "create: {arguments}")
    @CsvSource(value = {"1000,1", "2000,2"}, delimiter = ',')
    public void create(int budget, int expected) {
        assertThat(PurchaseList.purchase(budget, AutoLottoGenerator.getInstance()).amount())
                .isEqualTo(expected);
    }

    @ParameterizedTest(name = "create failed by not enough money: {arguments}")
    @ValueSource(ints = {-1000, 0, 999})
    public void createFailedByNotEnoughMoney(int budget) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseList.purchase(budget, AutoLottoGenerator.getInstance()))
                .withMessageContaining("budget must be at least 1000");
    }


    @ParameterizedTest(name = "create failed change exist: {arguments}")
    @ValueSource(ints = {1999, 1001})
    public void createFailedByChaneExist(int budget) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseList.purchase(budget, AutoLottoGenerator.getInstance()))
                .withMessageContaining("budget must be multiple of 1000");
    }

    @Test
    public void collect() {
        final List<Lotto> lottoList = List.of(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)));
        final PurchaseList testlist = PurchaseList.purchase(1000, FixedLottoGenerator.getInstance());
        assertThat(testlist.collect()).hasSameElementsAs(lottoList);
    }

    static Stream<Arguments> parseWinningResult() {
        return Stream.of(
                // 0 matched
                Arguments.of(
                        Lotto.fromIntegers(List.of(10, 11, 12, 13, 14, 15)),
                        GameResult.of(0, 0, 0, 0)
                ),
                // 1 matched
                Arguments.of(
                        Lotto.fromIntegers(List.of(1, 11, 12, 13, 14, 15)),
                        GameResult.of(0, 0, 0, 0)
                ),
                // 2 matched
                Arguments.of(
                        Lotto.fromIntegers(List.of(1, 2, 12, 13, 14, 15)),
                        GameResult.of(0, 0, 0, 0)
                ),
                // 3 matched
                Arguments.of(
                        Lotto.fromIntegers(List.of(1, 2, 3, 13, 14, 15)),
                        GameResult.of(0, 0, 0, 1)
                )
        );
    }

    @ParameterizedTest(name = "check winning with FixedLotto: {0} -> {1}")
    @MethodSource("parseWinningResult")
    public void winningResult(Lotto winningNumber, GameResult expected) {
        assertThat(PurchaseList.purchase(1000, FixedLottoGenerator.getInstance()).winningResult(winningNumber))
                .isEqualTo(expected);

    }

    static Stream<Arguments> parseWPriceEarningRate() {
        return Stream.of(
                // first place
                Arguments.of(GameResult.of(1, 0, 0, 0), 2000000),
                // second place
                Arguments.of(GameResult.of(0, 1, 0, 0), 1500),
                // third place
                Arguments.of(GameResult.of(0, 0, 1, 0), 50),
                // fource place
                Arguments.of(GameResult.of(0, 0, 0, 1), 5),
                // no winning
                Arguments.of(GameResult.of(0, 0, 0, 0), 0)
        );
    }

    @ParameterizedTest(name = "price-earning rate: {0} -> {1}")
    @MethodSource("parseWPriceEarningRate")
    public void priceEarningRate(GameResult gameResult, float expected) {
        final PurchaseList purchaseList = PurchaseList.purchase(1000, FixedLottoGenerator.getInstance());
        assertThat(purchaseList.priceEarningRate(gameResult)).isEqualTo(expected);
    }
}
