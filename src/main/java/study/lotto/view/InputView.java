package study.lotto.view;

import study.lotto.controller.LottoStore;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.exception.LottoException;
import study.lotto.generator.ManualLottoNumberGenerator;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
    public static final String GUIDE_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String GUIDE_GREATER_THAN_LOTTO_COUNT = "구매할 수 있는 로또 갯수보다 많습니다.";
    public static final String GUIDE_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private static String inputScanner() {
        return in.nextLine();
    }

    public static int money() {
        System.out.println(GUIDE_PURCHASE_MONEY);
        final String inputMoney = inputScanner();

        isValidationInputData(isNotNullAndIsBlank(inputMoney), GUIDE_NOT_FOUND_MONEY);
        isValidationInputData(isCanNotBuyLotto(inputMoney), GUIDE_PURCHASE_LOTTO);

        return Integer.parseInt(inputMoney);
    }

    public static Lotto winningNumber() {
        System.out.println(GUIDE_LAST_WEEK_WINNING_NUMBER);
        final String inputWinningNumber = inputScanner();

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
        final String inputBonusNumber = inputScanner();

        isValidationInputData(isNotNullAndIsBlank(inputBonusNumber), GUIDE_NOT_FOUND_MONEY);
        isValidationInputData(!isNumeric(inputBonusNumber), GUIDE_CANNOT_PARSE_STRING);

        return new LottoNumber(inputBonusNumber);
    }

    public static int manualCount(final int money) {
        System.out.println(GUIDE_MANUAL_LOTTO_COUNT);
        int amount = in.nextInt();
        in.nextLine();
        if(money / LOTTO_PRICE < amount) {
            throw new LottoException(GUIDE_GREATER_THAN_LOTTO_COUNT);
        }
        return amount;
    }

    public static Lottos makeManualLotto(final int manualCount) {
        if(manualCount < 1) {
            return new Lottos(new ArrayList<>());
        }
        System.out.println(GUIDE_MANUAL_NUMBERS);

        List<Lotto> collect = IntStream.range(0, manualCount)
                .mapToObj(i -> inputScanner())
                .map(s -> new LottoStore(new ManualLottoNumberGenerator()).manualLotto(s))
                .collect(toList());

        return new Lottos(collect);
    }
}
