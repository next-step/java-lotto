package study.ascii92der.lotto.step3to5;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNER_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private final Scanner scanner;

    public InputView(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public LottoPrice inputMoney() {
        System.out.println(INPUT_MONEY);
        return new LottoPrice(Integer.parseInt(scanner.nextLine()));
    }

    public Lotto inputWinnerNumbers() {
        System.out.println(INPUT_WINNER_NUMBERS);
        List<Integer> winingNumbers = new ArrayList<>();

        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .forEach(winingNumbers::add);

        return new Lotto(winingNumbers);
    }

    public LottoNumber inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return new LottoNumber(Integer.parseInt(scanner.nextLine()));
    }
}
