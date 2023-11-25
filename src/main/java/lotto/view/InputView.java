package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoCountSummary;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.ManualLottoCount;
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

    public ManualLottoCount inputManualLottoCount(LottoCount totalLottoCount) {
        printer.printLine("수동으로 구매할 로또 수를 입력해 주세요.");
        String rawManualLottoCount = reader.readLine();
        validator.validateManualLottoCount(rawManualLottoCount, "수동 구매 로또 수");
        int manualLottoCount = Converter.convertToInt(rawManualLottoCount);
        return ManualLottoCount.of(manualLottoCount, totalLottoCount);
    }

    public Lottos inputManualLottos(LottoCountSummary lottoCountSummary) {
        printer.printLine("수동으로 구매할 번호를 입력해 주세요.");
        int manualLottoCount = lottoCountSummary.getManulLottoCount().getManualLottoCount();
        List<Lotto> manualLottos = IntStream.range(0, manualLottoCount)
                .mapToObj(inputCount -> inputManulLotto())
                .collect(Collectors.toList());
        return new Lottos(manualLottos);
    }

    private Lotto inputManulLotto() {
        String manualLotto = reader.readLine();
        validator.validateLotto(manualLotto, "수동 구매 번호");
        return Lotto.from(Converter.splitToIntList(InputValidator.LOTTO_NUMBER_SEPARATOR, manualLotto));
    }
}
