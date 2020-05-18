package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoLine;
import lotto.domain.LottoMatch;
import lotto.domain.LottoMatchResult;

public class OutputView {

    public static void printLottos(List<LottoLine> lottoLines){
        System.out.println(String.format("%d개를 구매했습니다.", lottoLines.size()));
        lottoLines.forEach(lottoLine -> printLotto(lottoLine));
        System.out.println();
    }

    public static void printLottoResult(LottoMatchResult result){
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        Arrays.asList(LottoMatch.values()).forEach(lottoMatch -> {
            String matchMessage = String.format("%s개 일치 (%d원)- %d개", lottoMatch.getMatchCount(), lottoMatch.getAmount(), result.get(lottoMatch));
            System.out.println(matchMessage);
        });

        double rate = result.computeProfitRate();

        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", rate, rate >=1.0f ? "이익" : "손해"));
    }

    private static void printLotto(LottoLine lottoLine) {
       List<Integer> nums = lottoLine.getNums();
       System.out.println(nums);
    }

}
