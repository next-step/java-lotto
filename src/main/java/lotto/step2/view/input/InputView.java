package lotto.step2.view.input;

import lotto.step2.domain.LottoTicket;
import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.PaymentInformation;
import lotto.step2.domain.WinningLottoNumbers;
import lotto.step2.utils.StringUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MANUAL_LOTTO_INPUT_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String COUNT_OF_MANUAL_LOTTO_INPUT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_FORMAT_EXCEPTION_MESSAGE = "올바른 입력 값이 아닙니다. 다시 입력해 주세요.";
    private static final String LOTTO_PAYMENT_PRICE_INPUT_MESSAGE = "\n구입금액을 입력해 주세요. (1000원 단위)";
    private static final String WINNING_LOTTO_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요. (구분자는 콤마, 각 숫자 범위는 1 ~ 45)";
    private static final String LOTTO_BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 볼을 입력해 주세요.";
    
    public static PaymentInformation inputLottoPaymentPrice() {
        try {
            System.out.println(LOTTO_PAYMENT_PRICE_INPUT_MESSAGE);
            final String paymentPrice = SCANNER.nextLine();
            checkBlankException(paymentPrice);
            return new PaymentInformation(paymentPrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoPaymentPrice();
        }
    }
    
    public static PaymentInformation inputCountOfManualLotto(PaymentInformation paymentInformation) {
        try {
            System.out.println(COUNT_OF_MANUAL_LOTTO_INPUT_MESSAGE);
            final String inputCountOfManualLotto = SCANNER.nextLine();
            checkBlankException(inputCountOfManualLotto);
            paymentInformation.inputCountOfManualLotto(inputCountOfManualLotto);
            return paymentInformation;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCountOfManualLotto(paymentInformation);
        }
    }
    
    public static LottoTickets inputManualLottoTickets(PaymentInformation paymentInformation) {
        try {
            System.out.println(MANUAL_LOTTO_INPUT_MESSAGE);
            return new LottoTickets(getLottoTickets(paymentInformation));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputManualLottoTickets(paymentInformation);
        }
    }
    
    private static List<LottoTicket> getLottoTickets(final PaymentInformation paymentInformation) {
        return IntStream.range(0, paymentInformation.countOfManualLotto())
                .mapToObj(index -> {
                    final String lottoTicket = SCANNER.nextLine();
                    checkBlankException(lottoTicket);
                    return new LottoTicket(lottoTicket);
                })
                .collect(Collectors.toList());
    }
    
    public static WinningLottoNumbers inputWinningLottoNumber() {
        try {
            System.out.println(WINNING_LOTTO_NUMBERS_INPUT_MESSAGE);
            final String winningLottoNumbersInput = SCANNER.nextLine();
            checkBlankException(winningLottoNumbersInput);
            return new WinningLottoNumbers(winningLottoNumbersInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningLottoNumber();
        }
    }
    
    public static WinningLottoNumbers inputWinningBonusLottoNumber(WinningLottoNumbers winningLottoNumbers) {
        try {
            System.out.println(LOTTO_BONUS_NUMBER_INPUT_MESSAGE);
            final String bonusNumber = SCANNER.nextLine();
            checkBlankException(bonusNumber);
            winningLottoNumbers.inputBonusNumber(bonusNumber);
            return winningLottoNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningBonusLottoNumber(winningLottoNumbers);
        }
    }
    
    private static void checkBlankException(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
