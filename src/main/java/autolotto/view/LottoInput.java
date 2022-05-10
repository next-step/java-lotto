package autolotto.view;

import autolotto.domain.LottoNumber;
import autolotto.domain.LottoNumbers;
import autolotto.exception.LottoException;
import autolotto.exception.LottoExceptionCode;

import java.util.*;
import java.util.stream.Collectors;

public class LottoInput {
    public static final String AMOUNT_QUESTION = "구입 금액을 입력해주세요. ex. 14000";
    public static final String WINNING_NUMBER_QUESTION = "지난주 당첨 번호를 콤마(,)를 기준으로 입력해주세요. ex. 1,2,3,4,5,6";
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static int askAmount() {
        System.out.println(AMOUNT_QUESTION);
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }

        return purchaseAmount;
    }

    public static Set<LottoNumber> askWinningNumber() {
        System.out.println(WINNING_NUMBER_QUESTION);
        String winningNumberInput = scanner.nextLine();
        return of(winningNumberInput);
    }

    public static List<LottoNumbers> createManualLotto(int manualQuantity) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>(manualQuantity);

        System.out.println("수동으로 구매할 번호를 입력해주세요.");

        for (int count = 0; count < manualQuantity; count++) {
            lottoNumbers.add(new LottoNumbers(of(scanner.nextLine())));
        }

        return lottoNumbers;
    }

    private static Set<LottoNumber> of(String LottoInput) {
        return Arrays.stream(LottoInput.split(DELIMITER))
                .map(String::trim)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public static int askManualLottoQuantity() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int quantity = Integer.parseInt(scanner.nextLine());
        if (quantity < 0) {
            throw new LottoException(LottoExceptionCode.INVALID_QUANTITY_NUMBER_TYPE, String.valueOf(quantity));
        }
        return quantity;
    }

    public static LottoNumber askBonusBall(Set<LottoNumber> winningNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBallInput = scanner.nextLine();

        LottoNumber lottoNumber = LottoNumber.of(bonusBallInput);
        if (winningNumbers.contains(lottoNumber)) {
            throw new LottoException(LottoExceptionCode.DUPLICATED_LOTTO_NUMBER, bonusBallInput);
        }
        return lottoNumber;
    }

    public static void printQuantities(int manualQuantity, int autoQuantity) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualQuantity, autoQuantity);
    }
}
