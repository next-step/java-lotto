package lotto.step2.service;

import lotto.step2.domain.Lotto;
import lotto.step2.input.PassiveLottoCount;
import lotto.step2.input.PurchaseAmount;
import lotto.step2.input.UserInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProgramManagerTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    @DisplayName("구매 금액, 수동으로 구매할 로또 수, 수동으로 구매할 로또 수만큼의 수동으로 구매할 번호를 입력하면, 구매 금액만큼의 로또 List를 발급한다.")
    void testGenerateLottos(final int passvieLottoCount) {
        //given
        final PurchaseAmount purchaseAmountInput = new PurchaseAmount(15000);
        final PassiveLottoCount passiveLottoCountInput = new PassiveLottoCount(passvieLottoCount, purchaseAmountInput.getMaxPassiveLottoCount());
        final List<Lotto> passiveLottos = generatePassiveLottos(passvieLottoCount);
        final UserInput input = new UserInput(purchaseAmountInput, passiveLottoCountInput, passiveLottos);

        //when
        final List<Lotto> lottos = LottoProgramManager.generateLottos(input);

        //then
        assertThat(lottos).hasSize(input.getTotalLottosCount());
    }

    private List<Lotto> generatePassiveLottos(final int passiveLottoCount) {
        final List<Lotto> passiveLottos = new ArrayList<>();

        for (int i = 0; i < passiveLottoCount; i++) {
            passiveLottos.add(new Lotto(Set.of(1, 2, 3, 4, 5, 6)));
        }

        return passiveLottos;
    }
}
