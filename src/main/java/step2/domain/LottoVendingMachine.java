package step2.domain;

public class LottoVendingMachine {

    public static int calculateRandomLottoPaperCount(int totalLottoPaperCount, int manualLottoPaperCount) {
        return totalLottoPaperCount - manualLottoPaperCount;
    }

    public LottoPapers makeLottoPapers(LottoPagersGenerator lottoPagersGenerator) {
        return lottoPagersGenerator.getLottoPapers();
    }
}
