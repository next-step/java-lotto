package study.lotto.view;

import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.view.dto.RequestMoney;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;
import static study.lotto.util.Validation.*;

public class InputView {

    public static final String GUIDE_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String GUIDE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String GUIDE_NOT_FOUND_MONEY = "금액을 지불하셔야 합니다.";
    public static final String GUIDE_PURCHASE_LOTTO = "로또를 구매할 수 없습니다.";
    public static final int LOTTO_PRICE = 1000;

    private static final Scanner in = new Scanner(System.in);
    public static final String GUIDE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String GUIDE_CANNOT_PARSE_STRING = "숫자가 아닙니다.";
    public static final String WHITE_SPACE = "";
    public static final String SPLIT_DELIMITER = ",";
    public static final String SPACIAL_CHARACTER_SPACE = "\\s";

    public static RequestMoney money() {
        System.out.println(GUIDE_PURCHASE_MONEY);
        final String inputMoney = in.nextLine();

        isValidationInputData(isNotNullAndIsBlank(inputMoney), GUIDE_NOT_FOUND_MONEY);
        isValidationInputData(isCanNotBuyLotto(inputMoney), GUIDE_PURCHASE_LOTTO);

        final int money = Integer.parseInt(inputMoney);
        return new RequestMoney(money);
    }

    public static Lotto winningNumber() {
        System.out.println(GUIDE_LAST_WEEK_WINNING_NUMBER);
        final String inputWinningNumber = in.nextLine();

        String[] splitWinningNumbers = splitWinningNumbers(inputWinningNumber);
        List<LottoNumber> collect = Arrays.stream(splitWinningNumbers)
                .map(LottoNumber::new)
                .collect(toList());

        return new Lotto(collect);
    }

    private static String[] splitWinningNumbers(String inputWinningNumber) {
        return inputWinningNumber.replaceAll(SPACIAL_CHARACTER_SPACE, WHITE_SPACE)
                .split(SPLIT_DELIMITER);
    }

    public static LottoNumber bonusNumber() {
        System.out.println(GUIDE_INPUT_BONUS_NUMBER);
        final String inputBonusNumber = in.nextLine();

        isValidationInputData(isNotNullAndIsBlank(inputBonusNumber), GUIDE_NOT_FOUND_MONEY);
        isValidationInputData(!isNumeric(inputBonusNumber), GUIDE_CANNOT_PARSE_STRING);

        return new LottoNumber(inputBonusNumber);
    }
}
