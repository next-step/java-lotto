package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoRunner {
    static public void run() {
        //UI관련 인스턴스 생성
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();

        //로또액수 입력
        int totalLottoPaperCount = inputView.enterLottoPrice();

        //수동입력 로또수 입력
        int manualLottoPaperCount = inputView.enterManualLottoPaperCount(totalLottoPaperCount);
        List<List<Integer>> manualLottoPapersInput = inputView.enterManualLottoPapers(manualLottoPaperCount);

        //로또번호 실행
        int randomLottoPaperCount = LottoVendingMachine.calculateRandomLottoPaperCount(totalLottoPaperCount, manualLottoPaperCount);
        LottoPapers manualLottoPapers = lottoVendingMachine.makeLottoPapers(new ManualGenerator(manualLottoPapersInput));
        LottoPapers randomLottoPapers = lottoVendingMachine.makeLottoPapers(new RandomGenerator(randomLottoPaperCount));
        LottoPapers allLottoPapers = manualLottoPapers.merge(randomLottoPapers);

        //실행결과 출력
        resultView.printLottoPapers(allLottoPapers, manualLottoPaperCount, randomLottoPaperCount);

        //로또 당첨번호 입력
        List<Integer> winLottoPaperInput = inputView.enterWinLottoPaper();
        LottoPaper winLottoPaper = new LottoPaper(winLottoPaperInput);
        BonusLottoNumber bonusLottoNumber = inputView.enterBonusLottoNumber(winLottoPaper);

        //로또실행값 통계 계산
        CountsByRank countsByRank = allLottoPapers.groupByRank(winLottoPaper, bonusLottoNumber);
        float revenueRatio = countsByRank.revenueRatio(allLottoPapers.size());

        //로또실행값 통계 출력
        List<Rank> excludeRanks = List.of(Rank.MISS);
        resultView.printCountByRank(countsByRank, excludeRanks);
        resultView.printRevenueRatio(revenueRatio);
    }

    static public void runWhile(Runnable runnable) {
        while (true) {
            runnable.run();
        }
    }

    public static void main(String[] args) {
        runWhile(() -> {
            try {
                LottoRunner.run();
                System.exit(0);
            } catch(Exception exception) {
                exception.printStackTrace();
            }
        });
    }
}
