package study.lotto.view;

import study.lotto.domain.LottoNumber;
import study.lotto.exception.LottoException;
import study.lotto.view.dto.RequestMoney;
import study.lotto.view.dto.RequestWinningNumber;

import java.util.Objects;
import java.util.Scanner;

public class InputView {

    public static final String GUIDE_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String GUIDE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String GUIDE_NOT_FOUND_MONEY = "금액을 지불하셔야 합니다.";
    public static final String GUIDE_PURCHASE_LOTTO = "로또를 구매할 수 없습니다.";
    public static final int LOTTO_PRICE = 1000;

    private static final Scanner in = new Scanner(System.in);
    public static final String GUIDE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String GUIDE_CANNOT_PARSE_STRING = "숫자가 아닙니다.";

    public static RequestMoney money() {
        System.out.println(GUIDE_PURCHASE_MONEY);
        final String inputMoney = in.nextLine();

        if(isNotNullAndIsBlank(inputMoney)) {
            throw new LottoException(GUIDE_NOT_FOUND_MONEY);
        }
        if(isCanNotBuyLotto(inputMoney)) {
            throw new LottoException(GUIDE_PURCHASE_LOTTO);
        }
        final int money = Integer.parseInt(inputMoney);
        return new RequestMoney(money);
    }

    private static boolean isNotNullAndIsBlank(final String inputMoney) {
        return Objects.isNull(inputMoney) || inputMoney.isEmpty();
    }

    private static boolean isCanNotBuyLotto(final String input) {
        return !isNumeric(input) || isLackOfMoney(input);
    }

    private static boolean isLackOfMoney(final String inputMoney) {
        return Integer.parseInt(inputMoney) < LOTTO_PRICE;
    }

    public static boolean isNumeric(final String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static RequestWinningNumber winningNumber() {
        System.out.println(GUIDE_LAST_WEEK_WINNING_NUMBER);
        final String inputWinningNumber = in.nextLine();

        return new RequestWinningNumber(inputWinningNumber);
    }

    public static LottoNumber bonusNumber() {
        System.out.println(GUIDE_INPUT_BONUS_NUMBER);
        final String inputBonusNumber = in.nextLine();

        if(isNotNullAndIsBlank(inputBonusNumber)) {
            throw new LottoException(GUIDE_NOT_FOUND_MONEY);
        }

        if(!isNumeric(inputBonusNumber)) {
            throw new LottoException(GUIDE_CANNOT_PARSE_STRING);
        }
        return new LottoNumber(inputBonusNumber);
    }
}
