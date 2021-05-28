package view;

import domain.LottoNumber;
import domain.LottoTicket;
import domain.LottoTickets;
import domain.WinningNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String DELIMITER = ", ";
    private static final String LOTTO_START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_MANUAL_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String LOTTO_MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String LOTTO_MISMATCH_NUMBER_MESSAGE = "로또 번호는 숫자만 가능합니다.";
    private static final String LOTTO_PURCHASE_AMOUNT_VALID_MESSAGE = "구입금액은 숫자만 입력 가능합니다.";
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "보너스 볼은 당첨 번호들이랑 달라야 합니다.";
    private static final String ERROR_MESSAGE_MONEY_NOT_ENOUGH = "1000원 이상의 금액을 입력해야 합니다.";
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int purchaseAmount() {
        System.out.println(LOTTO_START_MESSAGE);
        String inputLine = SCANNER.nextLine();
        inputDigitValid(inputLine);

        if(Integer.parseInt(inputLine) < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_NOT_ENOUGH);
        }

        return Integer.parseInt(inputLine);
    }

    public static int manualPurchaseLottoCount() {
        System.out.println(LOTTO_MANUAL_MESSAGE);
        int inputCount = 0;
        try {
            inputCount = Integer.parseInt(SCANNER.nextLine());
        } catch(InputMismatchException inputMismatchException) {
            throw new IllegalArgumentException(LOTTO_MISMATCH_NUMBER_MESSAGE);
        }

        return inputCount;
    }

    public static LottoTickets manualLottoNumbers(int count) {
        System.out.println(LOTTO_MANUAL_NUMBER_MESSAGE);
        List<String> manualNumberStrings = new ArrayList<>();
        while (manualNumberStrings.size() != count) {
            String inputLine = SCANNER.nextLine();
            if(inputLine.isEmpty()) {
                continue;
            }
            manualNumberStrings.add(inputLine);
        }

        return manualNumber(manualNumberStrings);
    }

    public static LottoTickets manualNumber(List<String> manualNumberStrings) {
        List<LottoTicket> manualTickets = manualNumberStrings.stream()
                .map(manualNumberString -> new LottoTicket(mapLottoStringToLottoNumberList(manualNumberString)))
                .collect(Collectors.toList());

        return new LottoTickets(manualTickets);
    }

    public static WinningNumber winningNumber(String winningNumberString) {
        return new WinningNumber(mapLottoStringToLottoNumberList(winningNumberString));
    }

    public static String winningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_MESSAGE);
        return SCANNER.nextLine();
    }

    private static List<LottoNumber> mapLottoStringToLottoNumberList(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(DELIMITER))
                .map(value -> new LottoNumber(Integer.parseInt(value)))
                .collect(Collectors.toList());
    }

    private static void inputDigitValid(String inputLine) {
        if(inputLine.chars().anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_AMOUNT_VALID_MESSAGE);
        }
    }

    public static int bonusBall() {
        System.out.println(LOTTO_BONUS_NUMBER_MESSAGE);
        return SCANNER.nextInt();
    }

    public static LottoNumber bonusBall(int inputNumber, WinningNumber winningNumber) {
        LottoNumber lottoNumber = new LottoNumber(inputNumber);
        if(winningNumber.contains(lottoNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        }
        return lottoNumber;
    }
}
