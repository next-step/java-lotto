package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        Lottos lottos = new Lottos(getAmount(inputView));
        ResultView.printLottos(lottos);

        LottoResult result = lottos.result(getWinningNumbers(inputView));
        ResultView.printLottoResult(result);
        ResultView.printProfitRate(result);

        inputView.close();
    }

    public static int getAmount(InputView inputView) {
        return Integer.parseInt(inputView.nextLine("구입금액을 입력해 주세요."));
    }

    public static List<LottoNumber> getWinningNumbers(InputView inputView) {
        String[] numbers = inputView.nextLine("지난 주 당첨 번호를 입력해 주세요.").replace(" ", "").split(",");
        return Arrays.stream(numbers)
                .map(s -> new LottoNumber(s))
                .collect(Collectors.toList());
    }
}
