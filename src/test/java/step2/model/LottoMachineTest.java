package step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    public void 금액에_맞게_생성된_로또_개수_확인_테스트() {
        assertThat(lottoMachine.generateLottos(Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"), new Money(3000)))
                .hasSize(5);
    }

    @Test
    public void 사용자가_입력한_수동_로또_여러_장_생성하기() {
        List<String> userInputs = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");
        List<Lotto> expected = Arrays.asList(new Lotto(new int[]{1, 2, 3, 4, 5, 6}),
                new Lotto(new int[]{7, 8, 9, 10, 11, 12}));

        assertThat(lottoMachine.generateManualLottos(userInputs))
                .isEqualTo(expected);
    }

    @Test
    public void 사용자가_입력한_우승_로또_생성하기() {
        String userInput = "1, 2, 3, 4, 5, 6";
        Integer bonusNumber = 7;
        assertThat(lottoMachine.generateWinningLotto(userInput, bonusNumber))
                .isEqualTo(new WinningLotto(new int[]{1, 2, 3, 4, 5, 6}, bonusNumber));
    }
}
