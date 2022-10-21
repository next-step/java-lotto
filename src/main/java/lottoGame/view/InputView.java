package lottoGame.view;

import lottoGame.model.exception.InputException;
import lottoGame.model.InputParameter;
import lottoGame.model.lotto.Lotto;
import lottoGame.model.lotto.WinningLotto;
import lottoGame.model.lotto.lottoNumber.DefaultLottoNumber;
import lottoGame.model.lotto.lottoNumber.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    private static final String inputWinningNum = "지난 주 당첨 번호를 입력해주세요";

    public static InputParameter print() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        validateInput(amount);
        return new InputParameter(amount);
    }

    public static WinningLotto inputWinningNumer() {
        System.out.println(inputWinningNum);
        scanner.nextLine();
        String winningString = scanner.nextLine();
        return new WinningLotto(changeInteger(winningString));
    }

    private static void validateInput(int amount) {
        if (amount < 1000) {
            throw new InputException("최소 금액 이상을 입력해주세요");
        }
    }

    private static List<LottoNumber> changeInteger(String winningString) {
        return Arrays.stream(checkNumCount(split(winningString)))
                .map(Integer::parseInt)
                .map(DefaultLottoNumber::new)
                .collect(Collectors.toList());
    }

    private static String[] split(String winningString) {
        return winningString.split(",");
    }


    private static String[] checkNumCount(String[] split) {
        if (split.length > Lotto.LOTTO_NUMBER_SIZE) {
            throw new InputException("6개 이상의 숫자를 입력했습니다.");
        }
        return split;
    }
}
