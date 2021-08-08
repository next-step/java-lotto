package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.PurchaseAmount;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String WINNING_LOTTO_NUMBERS_DELIMITER = ",";

    private final Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = Objects.requireNonNull(scanner);
    }

    public static InputView of(InputStream inputStream) {
        return new InputView(new Scanner(inputStream));
    }

    public PurchaseAmount getPurchaseAmount() {
        String input = scanner.nextLine();
        return PurchaseAmount.of(Integer.parseInt(input));
    }

    public LottoNumbers getWinningLottoNumbers() {
        String input = scanner.nextLine();
        return LottoNumbers.of(parseWinningLottoNumbers(input));
    }

    private List<LottoNumber> parseWinningLottoNumbers(String input) {
        return Arrays.stream(input.split(WINNING_LOTTO_NUMBERS_DELIMITER))
                .map(numberString -> LottoNumber.of(Integer.parseInt(numberString.trim())))
                .collect(Collectors.toList());
    }
}
