package lotto.view;

import lotto.common.Symbol;
import lotto.domain.PurchaseAmount;
import lotto.util.converter.Converter;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;
import lotto.view.validator.InputValidator;

public class InputView {
    private static final String PLAYER_SEPARATOR = Symbol.COMMA;
    private final Reader reader;
    private final Printer printer;
    private final InputValidator validator;

    private InputView(Reader reader, Printer printer, InputValidator validator) {
        this.reader = reader;
        this.printer = printer;
        this.validator = validator;
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer, InputValidator.getInstance());
    }

    public PurchaseAmount inputPurchaseAmount() {
        printer.printLine("구입금액을 입력해 주세요.");
        String purchaseAmount = reader.readLine();
        validator.validatePurchaseAmount(purchaseAmount, "구입 금액");
        return PurchaseAmount.from(Converter.convertToInt(purchaseAmount));
    }
}
