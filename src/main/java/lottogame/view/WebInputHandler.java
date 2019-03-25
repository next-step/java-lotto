package lottogame.view;

import lottogame.domain.*;
import lottogame.service.LottoNumberGeneratorImpl;
import lottogame.validator.InputLineValidator;
import lottogame.validator.Validatable;
import spark.Request;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WebInputHandler {
    private static final String TEXT_AREA_LINE_DELIMITER = "\r\n";
    private static final Validatable<String> validator = new InputLineValidator();

    public static PurchaseAmount getPurchaseAmount(Request req) {
        return new PurchaseAmount(getInputLine(req, "purchaseAmount"));
    }

    public static List<LottoNumberPackage> getManualNumbers(Request req) {
        List<String> inputLines = getInputLines(req, "manualNumbers", TEXT_AREA_LINE_DELIMITER);

        return inputLines.stream()
                    .map(LottoNumberPackage::new)
                    .collect(Collectors.toList());
    }

    public static PurchaseCount getPurchaseCount(PurchaseAmount purchaseAmount, List<LottoNumberPackage> manualNumbers) {
        return new PurchaseCount(purchaseAmount.getLottoCount(), (long)manualNumbers.size());
    }

    public static LottoTicket getLottoTicket(PurchaseAmount purchaseAmount, List<LottoNumberPackage> manualNumbers, PurchaseCount purchaseCount) {
        return new LottoTicket(new PurchaseInfo(purchaseAmount, purchaseCount), manualNumbers, new LottoNumberGeneratorImpl());
    }

    public static LottoNumberPackage getWinningNumbers(Request req) {
        return new LottoNumberPackage(getInputLine(req, "winningNumbers"));
    }

    public static WinningInfo getWinningInfo(Request req, LottoNumberPackage winningNumbers) {
        return new WinningInfo(winningNumbers, getInputLine(req, "bonusNumber"));
    }

    private static String getInputLine(Request req, String key) {
        String inputLine = req.queryParams(key);
        validator.validate(inputLine);
        return inputLine;
    }

    private static List<String> getInputLines(Request req, String key, String delimiter) {
        return Optional.ofNullable(req.queryParams(key))
                .map(line -> line.split(delimiter))
                .map(Arrays::asList)
                .get()
                .stream()
                .collect(Collectors.toList());
    }
}
