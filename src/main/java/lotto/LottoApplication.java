package lotto;

import lotto.controller.ReportController;
import lotto.controller.RoundController;
import lotto.domain.LottoConstraint;
import lotto.service.AbstractPrizePackager;
import lotto.service.AutoPickService;
import lotto.service.LottoPrizePackager;
import lotto.service.LottoService;
import lotto.service.ReportService;
import lotto.service.RoundService;

public class LottoApplication {
    private static AbstractPrizePackager lottoPrizePackager;
    private static RoundController roundController;
    private static ReportController reportController;

    public static void main(String[] args) {
        setUpDependency();
        roundController.buyView();
        roundController.checkView();
        reportController.reportView();
    }

    private static void setUpDependency() {
        if(lottoPrizePackager == null){
            lottoPrizePackager = new LottoPrizePackager();
        }
        LottoService lottoService = new LottoService(1000, new LottoConstraint(6, 45), lottoPrizePackager);
        AutoPickService autoPickService = new AutoPickService(lottoService);
        RoundService roundService = new RoundService(autoPickService, lottoService);
        ReportService reportService = new ReportService(lottoService);
        roundController = new RoundController(roundService, lottoService);
        reportController = new ReportController(reportService, roundService, lottoService);
    }

    public static void setLottoPrizePackager(AbstractPrizePackager lottoPrizePackager) {
        LottoApplication.lottoPrizePackager = lottoPrizePackager;
    }
}
