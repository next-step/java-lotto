package lotto.step2.input;

import lotto.step2.service.LottoProgram;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {
    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 9000, 15000})
    @DisplayName("객체를 생성할 때 구매 금액과 수동으로 구매할 로또 수를 입력하면, 생성된 userInput 객체는 구매 금액를 가지고 있다.")
    void testUserInputConstructorForPurchaseAmount(final int userInputPurchaseAmount) {
        //given
        final PurchaseAmount purchaseAmountInput = new PurchaseAmount(userInputPurchaseAmount);
        final int maxPassiveLottoCount = purchaseAmountInput.getValue() / LottoProgram.LOTTO_PRICE;
        final PassiveLottoCount passiveLottoCountInput = new PassiveLottoCount(1, maxPassiveLottoCount);
        final UserInput input = new UserInput(purchaseAmountInput, passiveLottoCountInput);

        //when
        final int purchaseAmount = input.getPurchaseAmount();

        //then
        assertThat(purchaseAmount).isEqualTo(userInputPurchaseAmount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9, 12})
    @DisplayName("객체를 생성할 때 구매 금액과 수동으로 구매할 로또 수를 입력하면, 생성된 userInput 객체는 수동으로 구매할 로또 수를 가지고 있다.")
    void testUserInputConstructorForPassiveLottoCount(final int userInputPassiveLottoCount) {
        //given
        final PurchaseAmount purchaseAmountInput = new PurchaseAmount(15000);
        final int maxPassiveLottoCount = purchaseAmountInput.getValue() / LottoProgram.LOTTO_PRICE;
        final PassiveLottoCount passiveLottoCountInput = new PassiveLottoCount(userInputPassiveLottoCount, maxPassiveLottoCount);
        final UserInput input = new UserInput(purchaseAmountInput, passiveLottoCountInput);

        //when
        final int passiveLottoCount = input.getPassiveLottoCount();

        //then
        assertThat(passiveLottoCount).isEqualTo(userInputPassiveLottoCount);
    }
}
