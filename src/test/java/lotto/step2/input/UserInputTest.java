package lotto.step2.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {
    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 9000, 15000})
    @DisplayName("객체를 생성할 때 구매 금액과 수동으로 구매할 로또 수를 입력하면, 생성된 userInput 객체는 구매 금액를 가지고 있다.")
    void testUserInputConstructorForPurchaseAmount(final int userInputPurchaseAmount) {
        //given
        int passiveLottoCount = 3;
        UserInput input = new UserInput(userInputPurchaseAmount, passiveLottoCount);

        //when
        final int purchaseAmount = input.getPurchaseAmount();

        //then
        assertThat(purchaseAmount).isEqualTo(userInputPurchaseAmount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000, -3000})
    @DisplayName("객체를 생성할 때 구입금액이 0원 이하면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionWhenPurchaseAmountIsLessThanZeroAndEqualToZero(final int userInputPurchaseAmount) {
        //given
        int passiveLottoCount = 3;

        //when, then
        assertThatThrownBy(() -> new UserInput(userInputPurchaseAmount, passiveLottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("purchaseAmount must be greater than 0");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9, 12})
    @DisplayName("객체를 생성할 때 구매 금액과 수동으로 구매할 로또 수를 입력하면, 생성된 userInput 객체는 수동으로 구매할 로또 수를 가지고 있다.")
    void testUserInputConstructorForPassiveLottoCount(final int userInputPassiveLottoCount) {
        //given
        int purchaseAmount = 15000;
        UserInput input = new UserInput(purchaseAmount, userInputPassiveLottoCount);

        //when
        final int passiveLottoCount = input.getPassiveLottoCount();

        //then
        assertThat(passiveLottoCount).isEqualTo(userInputPassiveLottoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -3})
    @DisplayName("객체를 생성할 때 수동으로 구매할 로또 수가 0개 이하면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionWhenPassiveLottoCountIsLessThanZeroAndEqualToZero(final int userInputPassiveLottoCount) {
        //given
        int purchaseAmount = 15000;

        //when, then
        assertThatThrownBy(() -> new UserInput(purchaseAmount, userInputPassiveLottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("passiveLottoCount must be greater than 0");
    }
}
