package lotto.step2.input;

import lotto.step2.domain.Lotto;
import lotto.step2.service.LottoProgram;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {
    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 9000, 15000})
    @DisplayName("객체를 생성할 때 구매 금액과 수동으로 구매할 로또 수를 입력하면, 생성된 userInput 객체는 구매 금액를 가지고 있다.")
    void testUserInputConstructorForPurchaseAmount(final int userInputPurchaseAmount) {
        //given
        final UserInput input = makeUserInput(userInputPurchaseAmount, 1);

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
        final UserInput input = makeUserInput(15000, userInputPassiveLottoCount);

        //when
        final int passiveLottoCount = input.getPassiveLottoCount();

        //then
        assertThat(passiveLottoCount).isEqualTo(userInputPassiveLottoCount);
    }

    @Test
    @DisplayName("객체를 생성할 때 수동 로또 목록을 입력하면, 생성된 userInput 객체는 수동 로또 목록을 가지고 있다.")
    void testUserInputConstructorForPassiveLottos() {
        //given
        final PurchaseAmount purchaseAmountInput = new PurchaseAmount(15000);
        final PassiveLottoCount passiveLottoCountInput = new PassiveLottoCount(3, purchaseAmountInput.getMaxPassiveLottoCount());
        final List<Lotto> passiveLottosInput = generatePassiveLottos(3);
        final UserInput input = new UserInput(purchaseAmountInput, passiveLottoCountInput, passiveLottosInput);

        //when
        final List<Lotto> passiveLottos = input.getPassiveLottos();

        //then
        assertThat(passiveLottos).isEqualTo(passiveLottosInput);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13})
    @DisplayName("getAutoLottoCount() 메서드를 사용하면, 자동 로또의 개수를 알 수 있다.")
    void testGetAutoLottoCount(final int passiveLottoCount) {
        //given
        final UserInput input = makeUserInput(15000, passiveLottoCount);

        //when
        final int autoLottoCount = input.getAutoLottoCount();

        //then
        assertThat(autoLottoCount).isEqualTo(input.getTotalLottosCount() - passiveLottoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 9000, 15000})
    @DisplayName("getTotalLottosCount() 메서드를 사용하면, 전체 로또의 개수를 알 수 있다.")
    void testGetTotalLottoCount(final int purchaseAmount) {
        //given
        final UserInput input = makeUserInput(purchaseAmount, 1);

        //when
        final int totalLottosCount = input.getTotalLottosCount();

        //then
        assertThat(totalLottosCount).isEqualTo(purchaseAmount / LottoProgram.LOTTO_PRICE);
    }

    private UserInput makeUserInput(final int userInputPurchaseAmount, final int passiveLottoCount) {
        final PurchaseAmount purchaseAmountInput = new PurchaseAmount(userInputPurchaseAmount);
        final PassiveLottoCount passiveLottoCountInput = new PassiveLottoCount(passiveLottoCount, purchaseAmountInput.getMaxPassiveLottoCount());
        final List<Lotto> passiveLottos = generatePassiveLottos(passiveLottoCount);

        return new UserInput(purchaseAmountInput, passiveLottoCountInput, passiveLottos);
    }

    private List<Lotto> generatePassiveLottos(final int passiveLottoCount) {
        final List<Lotto> passiveLottos = new ArrayList<>();

        for (int i = 0; i < passiveLottoCount; i++) {
            passiveLottos.add(new Lotto(Set.of(1, 2, 3, 4, 5, 6)));
        }

        return passiveLottos;
    }
}
