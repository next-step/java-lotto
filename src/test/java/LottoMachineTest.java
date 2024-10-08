import model.Lotto;
import model.LottoNumberStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoMachineTest {
    @Test
    @DisplayName("lotto machine instantication")
    void createLottoMachineTest() {
        //given
        List<Integer> numbers = List.of(8, 21, 23, 41, 42, 43);
        Lotto lotto = new Lotto(numbers);
        List<Lotto> lottos = List.of(lotto);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int totalPrice = 14000;
        LottoNumberStrategy lottoNumberStrategy = new LottoNumberStrategy() {
        };

        //when
        LottoMachine lottoMachine = new LottoMachine(
                lottos,
                winningNumbers,
                totalPrice,
                lottoNumberStrategy
        );

        //then
        Assertions.assertThat(lottoMachine.getLottos()).hasSameElementsAs(lottos);
        Assertions.assertThat(lottoMachine.getWinningNumbers()).hasSameElementsAs(winningNumbers);
        Assertions.assertThat(lottoMachine.getTotalPrice()).isEqualTo(totalPrice);
        Assertions.assertThat(lottoMachine.getLottoNumberStrategy().create()).hasSize(6);
        Assertions.assertThat(lottoMachine.getNumberOfLotto()).isEqualTo(14);
    }
}
