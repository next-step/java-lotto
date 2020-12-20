package lotto.ui;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLottoNumberList(LottoCollection lottoCollection) {
        lottoCollection.getLottos()
                .stream()
                .map(Lotto::getSortedNumbers)
                .forEach(ResultView::printLottoNumber);

        System.out.println();
    }

    private static void printLottoNumber(List<LottoNumber> lottoNumbers) {
        List<String> convertedNumbers = lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println("[" + String.join(", ", convertedNumbers) + "]");
    }

    public static void printStatistics(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", result.getRankCount(Rank.FIFTH));
        System.out.printf("4개 일치 (50000원)- %d개\n", result.getRankCount(Rank.FOURTH));
        System.out.printf("5개 일치 (1500000원)- %d개\n", result.getRankCount(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치(30000000원)- %d개\n", result.getRankCount(Rank.SECOND));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", result.getRankCount(Rank.FIRST));
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", result.getRewardRate());
    }
}
