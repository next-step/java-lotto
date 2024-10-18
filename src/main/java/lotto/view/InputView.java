package lotto.view;

import lotto.model.dto.LottoNumber;
import lotto.util.SplitUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final int DIVIDE_AMOUNT = 1000;
    public static final String INPUT_BUY_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static int inputBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT);
        int buyAmount = SCANNER.nextInt();
        SCANNER.nextLine();// NOTE: nextInt 후에 Enter 키를 누르면 그 개행 문자가 입력 버퍼에 남아 있으므로 남아 있는 개행 문자 소비
        return buyAmount;
    }

    public static int calculateBuyCount(int buyAmount) {
        return buyAmount / DIVIDE_AMOUNT;
    }

    public static List<LottoNumber> inputWinningLottoNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
        Integer[] integers = SplitUtil.stringToNumbers(SCANNER.nextLine());
        return Arrays.stream(integers)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static LottoNumber inputBonusLottoNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        LottoNumber bonusNumber = LottoNumber.of(SCANNER.nextInt());
        SCANNER.nextLine();
        return bonusNumber;
    }
}
