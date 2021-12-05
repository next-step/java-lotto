package edu.nextstep.camp.lotto.domain;


import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static edu.nextstep.camp.lotto.domain.BudgetTest.budget;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StoreTest {
    @ParameterizedTest(name = "purchase(auto): {arguments}")
    @CsvSource(value = {"1000,1", "2000,2", "0,0"}, delimiter = ',')
    public void purchaseAuto(int budget, int expected) {
        assertThat(Store.purchase(budget(budget), AutoLottoGenerator.getInstance()).amount())
                .isEqualTo(expected);
    }

    @Test
    public void purchaseManually() {
        List<Set<Integer>> numbers = List.of(Set.of(1, 2, 3, 4, 5, 6));
        int budget = 2000;
        assertThat(Store.purchase(budget(budget), numbers).amount()).isEqualTo(numbers.size());
        assertThat(Store.purchase(budget(budget), numbers).collect())
                .hasSameElementsAs(numbers.stream().map(Lotto::fromIntegers).collect(Collectors.toList()));
    }

    static Stream<Arguments> parsePurchaseManuallyFailed() {
        return Stream.of(
                Arguments.of(1000, null, "cannot be null"),
                Arguments.of(1000, List.of(Set.of(1, 2, 3, 4, 5, 6), Set.of(1, 2, 3, 4, 5, 6)), "not enough money")
        );
    }

    @ParameterizedTest(name = "purchase manually failed by invalid input: {arguments}")
    @MethodSource("parsePurchaseManuallyFailed")
    public void purchaseManuallyFailedByNotEnoughMoney(int budget, Collection<Set<Integer>> lottos, String expectedMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Store.purchase(budget(budget), lottos))
                .withMessageContaining(expectedMessage);
    }
}
