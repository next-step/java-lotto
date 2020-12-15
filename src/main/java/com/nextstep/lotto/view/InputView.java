package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.Lotto;
import com.nextstep.lotto.domain.LottoSeller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;
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

    public static Lotto inputManualLottos() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return new Lotto(parseToList(SCANNER.nextLine()));
    }

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = parseInt(SCANNER.nextLine());
        if (price < LottoSeller.LOTTO_PRICE) {
            throw new IllegalArgumentException("최소 구입 금액은 " + LottoSeller.LOTTO_PRICE + "원 입니다.");
        }
        return price;
    }

    public static List<Integer> inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return parseToList(SCANNER.nextLine());
    }

    private static List<Integer> parseToList(String winningNumberString) {
        String[] numbers = winningNumberString.split(DELIMITER);
        if ( numbers.length != Lotto.LOTTO_NUMBER_COUNT ) {
            throw new IllegalArgumentException("숫자는 " + Lotto.LOTTO_NUMBER_COUNT + "개만 입력 가능합니다.");
        }
        return Stream.of(numbers)
                .map(InputView::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
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
