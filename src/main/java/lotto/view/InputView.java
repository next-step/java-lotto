package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.domain.LottoMachine.*;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요.";
    private static final String INPUT_RETRY = " 다시 입력해주세요.";
    public static final String INPUT_MIN_PRICE_MESSAGE = "금액은 최소 " + LOTTO_PRICE + "원 이상 입력이 가능합니다.";
    public static final String INPUT_CORRECT_PRICE_UNIT_MESSAGE = "금액은 " + LOTTO_PRICE + "원 단위로 입력이 가능합니다.";
    public static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_COUNT_OVER_MESSAGE = "구매한 총 로또 수를 초과할 수 없습니다.";

    private static final Scanner scanner = new Scanner(System.in);


    public int totalLottoCount(String message) {
        System.out.println(message);

        try {
            int money = scanPriceForBuyLotto();
            return money / LOTTO_PRICE;
        } catch (NumberFormatException e) {
            return totalLottoCount(INPUT_NUMBER_MESSAGE + INPUT_RETRY);
        } catch (IllegalArgumentException e) {
            return totalLottoCount(e.getMessage());
        }
    }

    public int manualLottoCount(int totalLottoCount) {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
        int manualLottoCount = Integer.parseInt(scanner.nextLine());
        if (manualLottoCount > totalLottoCount) {
            System.out.println(INPUT_MANUAL_LOTTO_COUNT_OVER_MESSAGE);
            return manualLottoCount(totalLottoCount);
        }
        return manualLottoCount;
    }

    public LottoTicket manualLottoTicket(int manualLottoCount) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        System.out.println(INPUT_MANUAL_LOTTO_MESSAGE);
        for (int i = 0; i < manualLottoCount; i++) {
            lottoNumbers.add(lottoNumbersInput(""));
        }
        return LottoTicket.from(lottoNumbers);
    }

    private int scanPriceForBuyLotto() {
        int priceForBuyLotto = Integer.parseInt(scanner.nextLine());

        if (isInputLowerThanPrice(priceForBuyLotto)) {
            throw new IllegalArgumentException(INPUT_MIN_PRICE_MESSAGE + INPUT_RETRY);
        }

        if (isInputPriceUnitWrong(priceForBuyLotto)) {
            throw new IllegalArgumentException(INPUT_CORRECT_PRICE_UNIT_MESSAGE + INPUT_RETRY);
        }

        return priceForBuyLotto;
    }

    public LottoNumbers lottoNumbersInput(String message) {
        if (!message.isBlank()){
            System.out.println(message);
        }
        String inputNumbers = scanner.nextLine();
        String[] splitInputNumbers = inputNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String splitInputNumber : splitInputNumbers) {
            numbers.add(Integer.parseInt(splitInputNumber.trim()));
        }

        try {
            return LottoNumbers.from(numbers);
        } catch (IllegalArgumentException e) {
            return lottoNumbersInput(e.getMessage() + INPUT_RETRY);
        }
    }

    public WinningNumber getFinalWinningNumber(String message, LottoNumbers winningNumber) {
        try {
            LottoNumber bonusNumber = getBonusNumber(message);
            return new WinningNumber(winningNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            return getFinalWinningNumber(e.getMessage() + INPUT_RETRY, winningNumber);
        }
    }

    private LottoNumber getBonusNumber(String message) {
        System.out.println(message);
        int inputNumber = Integer.parseInt(scanner.nextLine());

        try {
            return LottoNumber.valueOf(inputNumber);
        } catch (IllegalArgumentException e) {
            return getBonusNumber(e.getMessage() + INPUT_RETRY);
        }
    }
}
