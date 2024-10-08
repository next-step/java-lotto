package step2.view;

import step2.constant.Prize;
import step2.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final StringBuilder sb = new StringBuilder();

    public void printLottoNumbers(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
        System.out.println();
    }

    public void printResult(Map<Integer, Integer> countMap, int cashAmount, String profitRate) {
        sb.append("\n").append("당첨 통계").append("\n").append("---------").append("\n");
        Arrays.stream(Prize.values()).forEach(p -> {
            sb.append(p.getResult()).append(" ").append(countMap.getOrDefault(p.getMatchCount(), 0)).append("개").append("\n");
        });

        sb.append("총 수익률은 ").append(profitRate).append("입니다. ");
        if (Double.parseDouble(profitRate) < 1) {
            sb.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)").append("\n");
        }

        System.out.println(sb.toString());
    }

}
