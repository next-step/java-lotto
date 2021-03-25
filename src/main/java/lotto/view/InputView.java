package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String WINNER_DELIMITER = ", ";
    private static final int NUMBER_LENGTH_BOUNDARY = 2;

    private InputView() {
    }

    public static String getLottoMoney() {
        System.out.println("구입금액을 입력해 주세요");
        return SCANNER.nextLine();
    }

    public static WinningLotto getWinningLotto() {
        System.out.println("지난 주 당첨번호를 입력해 주세요");
        String[] inputWinner = SCANNER.nextLine().split(WINNER_DELIMITER);
        System.out.println("보너스 볼을 입력해 주세요");
        String bonusBall = SCANNER.nextLine();
        validateInputWinner(inputWinner, bonusBall);
        return new WinningLotto(parseLottoNumber(inputWinner), parseBonusBall(bonusBall));
    }

    private static LottoNumber parseBonusBall(String bonusBall) {
        validateNumber(bonusBall);
        int parseBonusBall = Integer.parseInt(bonusBall);
        return new LottoNumber(parseBonusBall);
    }

    private static List<LottoNumber> parseLottoNumber(String[] inputWinner) {
        for (String number : inputWinner) {
            validateNumber(number);
        }
        return Arrays.stream(inputWinner)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    private static void validateInputWinner(String[] inputWinner, String bonusBall) {
        Set<String> removeDuplicate = Arrays.stream(inputWinner).collect(Collectors.toSet());
        if (inputWinner.length != removeDuplicate.size()) {
            throw new IllegalArgumentException("동일한 숫자를 입력할 수 없습니다");
        }
        if (bonusBall.trim().isEmpty()) {
            throw new IllegalArgumentException("보너스 숫자를 입력해주세요");
        }
        if (bonusBall.length() > NUMBER_LENGTH_BOUNDARY) {
            throw new IllegalArgumentException("보너스 숫자는 최대 45입니다");
        }
    }
}
