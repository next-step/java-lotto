package lotto.view;

import lotto.domain.lotto.Ticket;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    public void 숫자_입력_테스트() {
        int money = InputView.getMoney("구입금액 입력하세요. ", new Scanner("5"));
        int bonusNumber = InputView.getBonusNumber("보너스볼을 입력하세요. ", new Scanner("5"));
        int manualCount = InputView.getManualCount("수동구매 수를 입력하세요. ", new Scanner("5"));

        assertThat(money).isEqualTo(5);
        assertThat(bonusNumber).isEqualTo(5);
        assertThat(manualCount).isEqualTo(5);
    }

    @Test
    public void 문자열_입력_테스트_전체_커버() {
        Scanner scanner = new Scanner("1, 2, 3, 4, 5, 6");
        String question = "지난 주 당첨 번호를 입력해 주세요.";
        Ticket winningLottoTicket =
            InputView.getWinningLottoNumbers(question, ",", scanner);

        assertThat(winningLottoTicket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 매뉴얼_로또_입력_테스트() {
        Scanner scanner = new Scanner("1, 2, 3, 4, 5, 6\n 1, 2, 3, 4, 5, 6");
        List<Ticket> manualLottoNumbers =
            InputView.getManualLottoNumbers("\n수동으로 구매할 번호를 입력해 주세요.", ",", scanner, 2, false);
        System.out.println(manualLottoNumbers.size());
    }
}
