package lotto.view;

import lotto.entity.Lotto;
import lotto.entity.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoInputView extends InputView {
    public int inputMoney() {
        return process(() -> {
            System.out.println("구입금액을 입력해 주세요.");
            return inputNumber();
        });
    }

    public List<Lotto> inputManualLotto() {
        return process(() -> {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            var lottoCount = inputNumber();

            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            return IntStream.range(0, lottoCount)
                    .mapToObj(i -> inputLotto())
                    .collect(Collectors.toList());
        });
    }

    public WinningLotto inputWinningLotto() {
        return process(() -> {
            System.out.println("지난 주 당첨번호를 입력해 주세요.");
            var winningLotto = inputLotto();

            System.out.println("보너스 볼을 입력해 주세요.");
            var bonusNumber = inputNumber();
            return new WinningLotto(winningLotto, bonusNumber);
        });
    }

    private Lotto inputLotto() {
        var lottoNumbers = Arrays.stream(inputString().split(","))
                .map(s -> {
                    var result = s.trim();
                    return Integer.parseInt(result);
                })
                .collect(Collectors.toSet());

        return new Lotto(lottoNumbers);
    }
}
