package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.util.converter.Converter;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;
import lotto.view.validator.InputValidator;

public class InputView {
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

    public Lotto inputWinningLotto() {
        printer.printLine("지난 주 당첨 번호를 입력해 주세요.");
        String lotto = reader.readLine();
        validator.validateLotto(lotto, "당첨 번호");
        return Lotto.from(Converter.splitToIntList(InputValidator.LOTTO_NUMBER_SEPARATOR, lotto));
    }

    public LottoNumber inputBonusBall() {
        printer.printLine("보너스 볼을 입력해 주세요.");
        String bonusBall = reader.readLine();
        validator.validateBonusBall(bonusBall, "보너스 볼");
        return LottoNumber.from(Converter.convertToInt(bonusBall));
    }
}
