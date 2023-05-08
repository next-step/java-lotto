package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @Test
    @DisplayName("Money  생성 테스트")
    void initMoneyTest() {
        assertThat(Money.wons(3000))
                .isInstanceOf(Money.class);
    }

    @ParameterizedTest
    @ValueSource(longs = {-2, -1, -5})
    @DisplayName("Money에 0원 이하가 들어올 경우 예외를 던진다")
    void validateUnderZero(long amount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.wons(amount))
                .withMessage("금액을 확인해주세요 :(");
    }

    @Test
    @DisplayName("Money에 0원 이하를 뺄 경우 예외를 던진다 ")
    void validateMinusUnderZero() {

        Money moneyOne = Money.wons(1000);
        Money moneyTwo = Money.wons(2000);


        moneyOne = moneyOne.minus(moneyTwo);

        Money finalMoneyOne = moneyOne;
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  finalMoneyOne.minus(moneyTwo))
                .withMessage("0원 이하를 뺼수 없어요 :(");

    }

    @Test
    @DisplayName("Money에 0원 이하를 뺄 경우 예외를 던진다 - 피연산 대상")
    void validateMinusUnderZero_() {

        Money moneyOne = Money.wons(2000);
        Money moneyTwo = Money.wons(1000);
        
        moneyTwo = moneyTwo.minus(moneyOne);

        Money finalMoneyTwo = moneyTwo;
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  moneyOne.minus(finalMoneyTwo))
                .withMessage("0원 이하를 뺼수 없어요 :(");

    }


}