import controller.LottoController;
import domain.Lotto;
import domain.LottoMachine;
import domain.MyLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.LottoOutput;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTest {

    @Test
    @DisplayName("로또 번호 확인")
    public void list() {
        List<Integer> mynumbers = List.of(1, 2, 3, 9, 22, 33);
        Lotto lotto = new Lotto(mynumbers);

        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);


    }

    @Test
    @DisplayName("로또 기게 랜덤 숫자")
    public void totalLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine.pull()).isEqualTo(6);

    }

    @Test
    @DisplayName("내 로또 번호들과 당첨 번호 비교")
    public void lottoPrize() {
        MyLotto myLotto = new MyLotto();
        List<Integer> win = List.of(1, 5, 7, 8, 9, 4);

    }

    @Test
    @DisplayName("당첨 결과 반환")
    public void winningStatus() {
        LottoController controller = new LottoController();

    }

    @Test
    @DisplayName("출력 로또 번호")
    public void myLottoNumbers() {
        LottoController lotto = new LottoController();

        lotto.totalLotto(4);

    }
}
