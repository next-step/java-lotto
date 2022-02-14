package lotto.domain.budget;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BudgetTest {

    @DisplayName("정상적인 구매 금액을 받아 객체를 생성하면 예외가 발생하지 않는다.")
    @Test
    void Given_정상_매개변수_When_객체_생성_Then_예외가_발생하지_않음() {
        final String input = "14000";

        Assertions.assertDoesNotThrow(() -> new Budget(input));
    }

    @DisplayName("구매 금액에 문자가 포함되어 있으면 예외가 발생한다.")
    @ValueSource(strings = {"1400 0", "aaa", "12a", "12 a"})
    @ParameterizedTest
    void Given_문자가_포함된_금액_문자열_When_객체_생성_Then_예외_발생(final String input) {
        assertThrows(IllegalArgumentException.class, () -> new Budget(input));
    }

    @DisplayName("로또의 가격이 주어지면 구매 가능한 로또 수를 반환한다..")
    @Test
    void Given_로또_가격보다_큰_투입_금액_When_구매가능_수_구하기_Then_구매_가능한_로또_수_반환() {
        final int numberOfPurchase = new Budget("5000").getNumberOfPurchase();

        assertThat(numberOfPurchase).isEqualTo(5);
    }

    @DisplayName("구매 금액이 로또 한장의 가격보다도 적으면 예외가 발생한다.")
    @Test
    void Given_로또_가격보다_적은_투입_금액_When_구매가능_수_구하기_Then_예외_발생() {
        assertThrows(IllegalArgumentException.class,
                () -> new Budget("500").getNumberOfPurchase());

    }

    @DisplayName("예산 금액이 차감 금액보다 적으면 예외가 발생한다.")
    @Test
    void Given_차감_금액보다_적은_투입_금액_When_금액만큼_차감_Then_예외_발생() {
        assertThrows(IllegalArgumentException.class,
                () -> new Budget("500").deductionPerLotto(1));
    }

    @DisplayName("차감 금액이 주어지면 차감된 예산을 가지는 객체를 새로 생성해 반환한다..")
    @Test
    void Given_차감_금액보다_큰_투입_금액_When_금액만큼_차감_Then_value값_차감() {
        final Budget budget = new Budget("5000");

        Budget result = budget.deductionPerLotto(1);

        assertThat(result).isEqualTo(new Budget("4000"));
    }
}
