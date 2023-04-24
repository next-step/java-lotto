package lotto.view;

import lotto.dto.LottoNumbersDto;
import lotto.dto.LottoStaticsDto;

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
        System.out.print("[");
        int sizeOfLottoNumber = lottoNumber.size();
        for (int i = 0; i < sizeOfLottoNumber - 1; i++) {
            System.out.print(lottoNumber.get(i) + ", ");
        }
        System.out.println(lottoNumber.get(sizeOfLottoNumber - 1) + "]");
    }

    public static void outputLottoStatistics(LottoStaticsDto dto) {
        Map<Integer, Integer> matchingCounts = dto.getMatchingCounts();
        Map<Integer, Integer> matchingPrices = dto.getMatchingPrices();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int key : matchingCounts.keySet()) {
            System.out.println(key +"개 일치 (" +
                    matchingPrices.get(key) +
                    "원)- " +
                    matchingCounts.get(key) +
                    "개");
        }

        System.out.printf("총 수익률은 " + "%.2f" +
                "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", dto.getGrossRateOfEarnings());
    }
}
