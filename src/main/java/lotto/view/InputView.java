package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.domain.PurchaseQuantity;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String LOTTO_NUMBERS_INPUT_DELIMITER = ",";

    private final Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = Objects.requireNonNull(scanner);
    }

    public static InputView of(InputStream inputStream) {
        return new InputView(new Scanner(inputStream));
    }

    public Money getPurchaseMoney() {
        String input = scanner.nextLine();
        return Money.of(Integer.parseInt(input));
    }

    public List<LottoNumbers> getManualLottoNumbers(long quantity) {
        return Stream.generate(this::getLottoNumbers)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    public LottoNumbers getLottoNumbers() {
        String input = scanner.nextLine();
        return LottoNumbers.of(parseLottoNumbers(input));
    }

    private List<LottoNumber> parseLottoNumbers(String input) {
        return Arrays.stream(input.split(LOTTO_NUMBERS_INPUT_DELIMITER))
                .map(numberString -> LottoNumber.of(Integer.parseInt(numberString.trim())))
                .collect(Collectors.toList());
    }

    public LottoNumber getBonusBall() {
        return LottoNumber.of(Integer.parseInt(scanner.nextLine()));
    }

    public PurchaseQuantity getManualPurchaseQuantity() {
        return PurchaseQuantity.of(Long.parseLong(scanner.nextLine()));
    }
}
