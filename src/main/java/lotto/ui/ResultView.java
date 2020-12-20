package lotto.ui;

import lotto.domain.LottoCollection;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;

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
        System.out.printf("3개 일치 (5000원)- %d개\n", result.getSameLottoCount(3));
        System.out.printf("4개 일치 (50000원)- %d개\n", result.getSameLottoCount(4));
        System.out.printf("5개 일치 (1500000원)- %d개\n", result.getSameLottoCount(5));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", result.getSameLottoCount(6));
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", result.getRewardRate());
    }
}
