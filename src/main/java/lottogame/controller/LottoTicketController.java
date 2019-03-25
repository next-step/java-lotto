package lottogame.controller;

import lottogame.domain.*;
import lottogame.service.LottoNumberGeneratorImpl;
import lottogame.util.StringUtils;
import spark.Request;
import spark.utils.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.post;

public class LottoTicketController extends AbstractController {

    private static final String TEXT_AREA_LINE_DELIMITER = "\r\n";
    private static final String TEMPLATE_PATH = "show.html";

    public static void getLottoTicket() {
        post( "/getLottoTicket", (req, res) -> {
            PurchaseAmount purchaseAmount = getPurchaseAmount(req);
            List<LottoNumberPackage> manualNumbers = getManualNumbers(req);

            if (Objects.isNull(purchaseAmount) || CollectionUtils.isEmpty(manualNumbers)) {
                redirectToIndex(res);
                return null;
            }

            try {
                PurchaseCount purchaseCount = getPurchaseCount(purchaseAmount, manualNumbers);
                LottoTicket lottoTicket = getLottoTicket(purchaseAmount, manualNumbers, purchaseCount);

                req.session().attribute(req.ip(), lottoTicket);

                Map<String, Object> model = new HashMap<>();
                model.put("lottoTicket", lottoTicket);

                return render(model, TEMPLATE_PATH);

            } catch (IllegalArgumentException e) {
                redirectToIndex(res);
                return null;
            }
        });
    }

    private static PurchaseAmount getPurchaseAmount(Request req) {
        return new PurchaseAmount(getInputLine(req, "purchaseAmount"));
    }

    private static List<LottoNumberPackage> getManualNumbers(Request req) {
        List<String> inputLines = getInputLines(req);

        return inputLines.stream()
                .map(LottoNumberPackage::new)
                .collect(Collectors.toList());
    }

    private static PurchaseCount getPurchaseCount(PurchaseAmount purchaseAmount, List<LottoNumberPackage> manualNumbers) {
        return new PurchaseCount(purchaseAmount.getLottoCount(), (long) manualNumbers.size());
    }

    private static LottoTicket getLottoTicket(PurchaseAmount purchaseAmount, List<LottoNumberPackage> manualNumbers, PurchaseCount purchaseCount) {
        return new LottoTicket(new PurchaseInfo(purchaseAmount, purchaseCount), manualNumbers, new LottoNumberGeneratorImpl());
    }

    private static List<String> getInputLines(Request req) {
        return new ArrayList<>(Optional.ofNullable(req.queryParams("manualNumbers"))
                .map(StringUtils::removeWhitespace)
                .map(line -> line.split(LottoTicketController.TEXT_AREA_LINE_DELIMITER))
                .map(Arrays::asList)
                .get());
    }

}
