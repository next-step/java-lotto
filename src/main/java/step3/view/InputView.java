package step3.view;

import step3.cache.LottoNumberCache;
import step3.domain.LottoNumber;
import step3.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MONEY_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return scanner.nextInt();
    }

    public static Lotto inputWinningNumbers() {
        scanner.nextLine();
        System.out.println(INPUT_WINNING_NUMBERS);
        List<LottoNumber> lottoNumberList = Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .map(LottoNumberCache::getLottoNumber)
                .collect(Collectors.toList());
        return new Lotto(lottoNumberList);

    }

    public static LottoNumber inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return LottoNumber.of(scanner.nextInt());
    }
}
