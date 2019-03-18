package lotto.view;

import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    public void 숫자_입력_테스트() {
        Scanner scanner = new Scanner("5");
        int money = InputView.getMoney("구입금액 입력하세요. ", scanner);

        assertThat(money).isEqualTo(5);
    }

    @Test
    public void 우승_로또_입력시_숫자_리스트로_반환() {
        Scanner scanner = new Scanner("1, 2, 3, 4, 5, 6");
        String question = "지난 주 당첨 번호를 입력해 주세요.";
        List<Integer> winningLottoNumbers =
            InputView.getWinningLottoNumbers(question, ",", scanner);

        assertThat(winningLottoNumbers.get(1)).isEqualTo(2);
        assertThat(winningLottoNumbers.get(3)).isEqualTo(4);
        assertThat(winningLottoNumbers.get(5)).isEqualTo(6);
    }
}
