package lotto.view;

import lotto.dto.LottoNumbersDto;
import lotto.dto.LottoStatisticsDto;

import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void outputLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void outputLottoNumbers(LottoNumbersDto dto) {
        List<List<Integer>> lottoNumbers = dto.getLottoNumbers();
        for (List<Integer> lottoNumber : lottoNumbers) {
            outputLottoNumber(lottoNumber);
        }
        System.out.println();
    }

    private static void outputLottoNumber(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public static void outputLottoStatistics(LottoStatisticsDto dto) {
        Map<Integer, Integer> matchingCounts = dto.getMatchingCounts();
        Map<Integer, Integer> matchingPrices = dto.getMatchingPrices();
        System.out.println("\n" + "당첨 통계");
        System.out.println("---------");

        for (int key : matchingCounts.keySet()) {
            System.out.printf("%d" + "개 일치 (" + "%d" + "원)- " + "%d" + "개" + "\n",
                    key, matchingPrices.get(key), matchingCounts.get(key));
        }

        outputGrossRateOfEarnings(dto);
    }

    private static void outputGrossRateOfEarnings(LottoStatisticsDto dto) {
        double grossRateOfEarnings = dto.getGrossRateOfEarnings();
        if (grossRateOfEarnings >= 1) {
            System.out.printf("총 수익률은 " + "%.2f" + "입니다.", grossRateOfEarnings);
            return;
        }
        System.out.printf("총 수익률은 " + "%.2f" +
                "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", grossRateOfEarnings);
    }
}
