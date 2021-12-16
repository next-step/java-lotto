package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int amount = getAmount(inputView);
        int passiveLottosCount = getPassiveLottoCount(inputView);

        Lottos lottos = new Lottos(amount, getPassiveLotto(inputView, passiveLottosCount));
        ResultView.printPassiveAndActiveLottos(lottos, passiveLottosCount);

        LottoResult result = lottos.result(getWinningNumbers(inputView), getBonusNumbers(inputView));
        ResultView.printLottoResult(result);
        ResultView.printProfitRate(result);

        inputView.close();
    }

    public static int getAmount(InputView inputView) {
        return Integer.parseInt(inputView.nextLine("구입금액을 입력해 주세요."));
    }

    public static int getPassiveLottoCount(InputView inputView) {
        return Integer.parseInt(inputView.nextLine("수동으로 구매할 로또 수를 입력해 주세요."));
    }

    public static List<Lotto> getPassiveLotto(InputView inputView, int passiveLottoCount) {
        List<Lotto> passiveLottos = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < passiveLottoCount; i++) {
            passiveLottos.add(new Lotto(getPassiveNumbers(inputView)));
        }
        return passiveLottos;
    }
    public static List<LottoNumber> getPassiveNumbers(InputView inputView) {
        String[] numbers = inputView.nextLine().replace(" ", "").split(",");
        return Arrays.stream(numbers)
                .map(s -> LottoNumber.of(s))
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> getWinningNumbers(InputView inputView) {
        String[] numbers = inputView.nextLine("지난 주 당첨 번호를 입력해 주세요.").replace(" ", "").split(",");
        return Arrays.stream(numbers)
                .map(s -> LottoNumber.of(s))
                .collect(Collectors.toList());
    }

    public static LottoNumber getBonusNumbers(InputView inputView) {
        int bonusNumber = Integer.parseInt(inputView.nextLine("보너스 볼을 입력해 주세요."));
        return LottoNumber.of(bonusNumber);
    }
}
