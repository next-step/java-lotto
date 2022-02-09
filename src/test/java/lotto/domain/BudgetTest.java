package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BudgetTest {

    @DisplayName("정상적인 구매 금액을 받아 객체를 생성하면 예외가 발생하지 않는다.")
    @Test
    void Given_정상_매개변수_When_객체_생성_Then_예외가_발생하지_않음() {
        // given
        final String input = "14000";

        // then
        Assertions.assertDoesNotThrow(() -> new Budget(input));
    }

    @DisplayName("구매 금액에 문자가 포함되어 있으면 예외가 발생한다.")
    @ValueSource(strings = {"1400 0", "aaa", "12a", "12 a"})
    @ParameterizedTest
    void Given_문자가_포함된_금액_문자열_When_객체_생성_Then_예외_발생(final String input) {
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Budget(input));
    }

    @DisplayName("구매 금액이 로또 한장의 가격보다 적으면 true 반환")
    @Test
    void Given_로또_가격보다_적은_투입_금액_When_구매가_불가능한지_판별_Then_true() {
        assertThat(new Budget("500").canNotPurchase(1000)).isTrue();
    }

    @DisplayName("구매 금액이 로또 한장의 가격보다 크면 ture 반환")
    @Test
    void Given_로또_가격보다_큰_투입_금액_When_구매가_불가능한지_판별_Then_false() {
        assertThat(new Budget("5000").canNotPurchase(1000)).isFalse();
    }

    @DisplayName("로또의 가격이 주어지면 구매 가능한 로또 수를 반환한다..")
    @Test
    void Given_로또_가격보다_큰_투입_금액_When_구매가능_수_구하기_Then_구매_가능한_로또_수_반환() {
        int numberOfPurchase = new Budget("5000").getNumberOfPurchase(1000);

        assertThat(numberOfPurchase).isEqualTo(5);
    }
}
