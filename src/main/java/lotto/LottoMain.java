package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {
        int amount = Input.getAmount();
        int issueCount = amount / 1000;

        LottoMachine lm = new LottoMachine();
        List<Lotto> lottos = lm.issue(issueCount);

        System.out.println(lottos.size() + "개를 구매하였습니다.");
        Result.printLottos(lottos);
        System.out.println();

        String inputWinningNumbers = Input.getWinningNumber();
        List<Integer> winningNumbers = StringUtil.convertIntList(StringUtil.split(inputWinningNumbers));

        System.out.println();

        if (Input.isValidNumbers(winningNumbers)) {

            System.out.println();
            List<Integer> results = new ArrayList<>();

            for (Lotto lotto : lottos) {
                int result = 0;
                result = lotto.getMatchCount(winningNumbers);
                results.add(result);
            }

            Map<Integer, Long> counts = results.stream().filter(i -> i >= 3).collect(Collectors.groupingBy(e -> e, Collectors.counting()));

            System.out.println("당첨 통계");
            System.out.println("---------");
            int earnAmount = 0;
            for (Map.Entry<Integer, Long> entry : counts.entrySet()) {
                int winMatchCount = entry.getKey();
                long matchCount = entry.getValue();
                LottoWinningCondition lottoWinningCondition = LottoWinningCondition.findByWinMatchCount(winMatchCount);
                int winMoney = lottoWinningCondition.getWinMoney();

                earnAmount += winMoney * matchCount;
                System.out.println(String.format("%s개 일치 (%s원) - %s개", winMatchCount, winMoney, matchCount));
            }

            BigDecimal earnRate = Result.getEarningRate(amount, earnAmount);
            System.out.println(String.format("총 수익률은 %s 입니다.", earnRate));
        }

    }


}
