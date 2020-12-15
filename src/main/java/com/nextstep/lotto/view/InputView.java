package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.Lotto;
import com.nextstep.lotto.domain.LottoNumber;
import com.nextstep.lotto.domain.LottoSeller;
import com.nextstep.lotto.domain.WinningLotto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputManualCount(int totalCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = parseInt(SCANNER.nextLine());
        if (totalCount < manualCount) {
            throw new IllegalArgumentException("현재 금액으로는 최대 " + totalCount + "장 구매 가능합니다.");
        }
        return manualCount;
    }

    public static Lotto inputManualLotto() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return new Lotto(parseToLottoNumbers(SCANNER.nextLine()));
    }

    public static int inputPriceToCount() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = parseInt(SCANNER.nextLine());
        return LottoSeller.count(price);
    }

    public static WinningLotto inputWinningLotto() {
        List<LottoNumber> lottoNumbers = inputWinnerNumbers();
        int bonusNumber = inputBonusNumber();
        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    private static List<LottoNumber> inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return parseToLottoNumbers(SCANNER.nextLine());
    }

    private static List<LottoNumber> parseToLottoNumbers(String winningNumberString) {
        String[] numbers = winningNumberString.split(DELIMITER);
        return Stream.of(numbers)
                .map(InputView::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = parseInt(SCANNER.nextLine());
        System.out.println();
        return bonusNumber;
    }

    private static int parseInt(String line) {
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(line + "은 숫자가 아닙니다.");
        }
    }
}
