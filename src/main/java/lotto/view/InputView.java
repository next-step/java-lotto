package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.domain.WinnerLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final Pattern NON_NUMERIC_PATTERN = Pattern.compile(".*[ㄱ-ㅎㅏ-ㅣ가-힣|a-z|A-Z]+.*");
    public static final Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER = ",";

    public static Money inputPrice() {
        System.out.println("구입금액을 입력해 주세요 :)");
        return Money.wons(scanner.nextInt());
    }

    public static WinnerLotto inputWinningNumbers() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 압력해주세요 :)");
        String inputWinnerLottoNumber = scanner.nextLine();
        validEmptyString(inputWinnerLottoNumber);
        validNonNumeric(inputWinnerLottoNumber);

        return WinnerLotto.of(new LottoNumbers(), toIntList(inputWinnerLottoNumber));
    }

    private static List<Integer> toIntList(String winnerLottoNumber) {
        return Arrays.stream(winnerLottoNumber.split(DELIMITER))
                .map(lottoNumber -> {
                    try {
                        return Integer.parseInt(lottoNumber);
                    }catch (NumberFormatException e){
                        throw new IllegalArgumentException("숫자만 입력 가능하세요 :(");
                    }
                })
                .collect(Collectors.toUnmodifiableList());
    }

    private static void validEmptyString(String inputWinnerLottoNumber) {
        if (inputWinnerLottoNumber == null) {
            throw new IllegalArgumentException("입력 값이 비었어요  :(");
        }
        if (inputWinnerLottoNumber.length() == 0) {
            throw new IllegalArgumentException("입력 값이 비었어요  :(");

        }
    }

    private static void validNonNumeric(String inputWinnerLottoNumber) {
        if (NON_NUMERIC_PATTERN.matcher(inputWinnerLottoNumber).find()) {
            throw new IllegalArgumentException("숫자만 입력 가능하세요 :(");
        }
    }
}
