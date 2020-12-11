package lotto;

import lotto.dto.PurchaseResponse;
import lotto.dto.ReportRequest;
import lotto.dto.ReportResponse;
import lotto.ui.LottoController;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Objects;

public class LottoApplication {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoController lottoController = appConfig.lottoController();
        PurchaseResponse purchaseResponse = lottoController.purchase(Objects.requireNonNull(InputView.purchase()));
        ResultView.print(purchaseResponse);

        ReportRequest reportRequest = new ReportRequest(
                Objects.requireNonNull(purchaseResponse.getLottoTickets()),
                Objects.requireNonNull(InputView.winningLotto()));
        ReportResponse reportResponse = lottoController.report(reportRequest);
        ResultView.print(reportResponse);
    }
}
