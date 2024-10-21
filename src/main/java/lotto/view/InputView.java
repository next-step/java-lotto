package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputPurchaseAmountGuide() {
        System.out.println("구매 금액을 입력해주세요.");
        return inputPurchaseAmount();
    }

    private int inputPurchaseAmount() {
        return scanner.nextInt();
    }

    public Lotto inputWinnerNumber() {
        clearBuffer();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(convertStringToIntList(scanner.nextLine()));
    }

    public LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNumber.createLottoNumber(scanner.nextInt());
    }

    private void clearBuffer() {
        scanner.nextLine();
    }

    public List<LottoNumber> convertStringToIntList(String stringWinningNumber) {
        return Arrays.stream(splitString(stringWinningNumber))
                .map(Integer::parseInt)
                .map(LottoNumber::createLottoNumber)
                .collect(Collectors.toList());
    }

    private String[] splitString(String stringWinningNumber) {
        return stringWinningNumber.split(", ");
    }

}
