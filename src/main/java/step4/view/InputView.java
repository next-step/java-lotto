package step4.view;

import step4.lotto.Lotto;
import step4.lotto.LottoNo;
import step4.lotto.LottoNumber;
import step4.lotto.exception.ExceptionMessage;
import step4.lotto.exception.InvalidLottoNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INVALID_PURCHASE_AMOUNT = "구매 금액이 올바르지 않습니다";
    private static final String INVALID_INPUT = "입력값이 올바르지 않습니다";
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public void print(String input) {
        System.out.println(input);
    }

    public int receiveInput() {
        print(ENTER_PURCHASE_AMOUNT);
        String input = SCANNER.nextLine();
        if (emptyInput(input)) {
            print(INVALID_INPUT);
            return receiveInput();
        }

        int purchaseAmount = parseInt(input);
        if (purchaseAmount < Lotto.PRICE) {
            print(INVALID_PURCHASE_AMOUNT);
            return receiveInput();
        }

        return purchaseAmount;
    }

    public int receiveManualLottoCount(long money) {
        print("수동으로 구매할 로또 수를 입력해 주세요.");
        String input = SCANNER.nextLine();
        if (emptyInput(input)) {
            print(INVALID_INPUT);
            return receiveManualLottoCount(money);
        }

        int manualLottoCount = parseInt(input);
        int manualLottoPrice = Lotto.PRICE * manualLottoCount;
        if (money - manualLottoPrice < 0) {
            print(ExceptionMessage.NOT_ENOUGH_MONEY);
            return receiveManualLottoCount(money);
        }

        return manualLottoCount;
    }

    public List<LottoNumber> receiveManualLottoNumber(int lottoCount) {
        print("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            LottoNumber lottoNumber = receiveLottoNumber();
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private LottoNumber receiveLottoNumber() {
        String input = SCANNER.nextLine();
        if (emptyInput(input)) {
            print(INVALID_INPUT);
            return receiveLottoNumber();
        }

        String[] split = input.replaceAll("\\s", "").split(",");
        List<Integer> numbers = Arrays.stream(split)
                .mapToInt(this::parseInt)
                .boxed()
                .collect(Collectors.toList());

        return getLottoNumber(numbers);
    }

    private LottoNumber getLottoNumber(List<Integer> numbers) {
        try {
            return new LottoNumber(numbers);
        } catch (InvalidLottoNumberException e) {
            print(e.getMessage());
            return receiveLottoNumber();
        }
    }

    public LottoNumber receiveLastWeekWinningNumber() {
        print("지난 주 당첨 번호를 입력해 주세요.");
        return receiveLottoNumber();
    }

    public LottoNo receiveBonusNumber(LottoNumber lottoNumber) {
        print("보너스 볼을 입력해 주세요.");
        String input = SCANNER.nextLine();
        if (emptyInput(input)) {
            print(INVALID_INPUT);
            return receiveBonusNumber(lottoNumber);
        }
        try {
            int bonusNo = parseInt(input);
            LottoNo lottoNo = new LottoNo(bonusNo);
            boolean duplicated = lottoNumber.contains(lottoNo);

            if (duplicated)
                throw new InvalidLottoNumberException(ExceptionMessage.NUMBER_DUPLICATED_BONUS_NUMBER);

            return lottoNo;
        } catch (InvalidLottoNumberException e) {
            print(e.getMessage());
            return receiveBonusNumber(lottoNumber);
        }
    }

    private boolean emptyInput(String input) {
        return "".equals(input);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            print("숫자를 입력하세요");
            return parseInt(SCANNER.nextLine());
        }
    }

    public void close() {
        SCANNER.close();
    }

}
