package lotto;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        Lottos lottos = new Lottos(getAmount(inputView));
        ResultView.printLottos(lottos);

        inputView.close();
    }

    public static int getAmount(InputView inputView) {
        return Integer.parseInt(inputView.nextLine("구입금액을 입력해 주세요."));
    }
}
