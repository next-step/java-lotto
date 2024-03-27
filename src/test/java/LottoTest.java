import controller.LottoController;
import domain.Lotto;
import domain.LottoMachine;
import domain.MyLotto;
import domain.WinStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.LottoOutput;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTest {

    @Test
    @DisplayName("로또 번호 확인")
    public void list() {
        List<Integer> mynumbers = new ArrayList<>(List.of(1, 2, 3, 9, 22, 33));
        Lotto lotto = new Lotto(mynumbers);
        List<Integer> winningNumber = List.of(1, 2, 3, 9, 22, 33);

        assertThat(lotto.getNumbers()).isEqualTo(winningNumber);
    }

    @Test
    @DisplayName("로또 기게 랜덤 숫자")
    public void totalLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine.pull().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 결과 반환")
    public void winningStatus() {
        LottoController controller = new LottoController();

    }

    @Test
    @DisplayName("출력 로또 번호")
    public void myLottoNumbers() {
        WinStatus winStatus = new WinStatus();
        winStatus.correct(0);
        winStatus.correct(1);
        winStatus.correct(2);
        winStatus.correct(3);
        assertThat(winStatus.getWinCount().length).isEqualTo(4);
    }
}
