package lotto.view;

import lotto.model.LottoNumbers;
import lotto.model.LottoRanking;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public void print(List<LottoNumbers> lottoNumbers) {

        lottoNumbers.stream()
                .map(LottoNumbers::lottoNumbers)
                .forEach(System.out::println);

        System.out.println();
    }

    public void printInputMoneyError(){
        System.out.println("금액을 천원 단위로 입력 하세요.");
    }

    public void printBonusBallError(){
        System.out.println("보너스 볼은 당첨 번호와 달라야 합니다.");
    }

    public void print(int manualBuyCount, int autoBuyCount){
        System.out.println("수동으로 " + manualBuyCount + "장 자동으로 " + autoBuyCount + "개를 구매했습니다.");
    }

    public void print() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void print(Map<LottoRanking, Integer> lottoResult, float rateOfReturn) {
        System.out.println(new StringBuilder().append(rankingPrintInfo(lottoResult)).append(rateResultString(rateOfReturn)));
    }

    private String rankingPrintInfo(Map<LottoRanking, Integer> lottoResult) {
        return Arrays.stream(LottoRanking.values())
                .filter(ranking -> !ranking.equals(LottoRanking.MISS))
                .map((LottoRanking) -> resultString(LottoRanking, lottoResult.get(LottoRanking)))
                .sorted()
                .collect(Collectors.joining());
    }

    private String resultString(LottoRanking lottoRanking, int count) {
        if (lottoRanking.equals(LottoRanking.SECOND)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n", lottoRanking.getCorrectCount(), lottoRanking.getPrice(), count);
        }

        return String.format("%d개 일치 (%d원)- %d개\n", lottoRanking.getCorrectCount(), lottoRanking.getPrice(), count);
    }

    private String rateResultString(float rateOfReturn) {
        return String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임",
                String.format("%.2f", rateOfReturn), LottoResultMessage.message(rateOfReturn));
    }
}
