package lotto.oop.ui;

import lotto.oop.domain.Rank;

import java.math.BigDecimal;
import java.util.Map;

public class ResultView {
    private Map<Rank, Integer> result;
    private int amount;
    public ResultView(Map<Rank, Integer> result, int amount) {
        this.result = result;
        this.amount = amount;
    }

    public void displayIssueStats() {
        System.out.println("당첨 통계");
        System.out.println("________");
        System.out.println("3개 일치 (5,000원)- " + result.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000)- " + result.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원)- " + result.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30,000,000원)- " + result.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원)- " + result.get(Rank.FIRST) + "개");
        displayGrossReturn();
    }

    private void displayGrossReturn() {
        double doubleTotalSum = getDoubleTotalSum();
        double grossReturn = (((doubleTotalSum / amount) - 1) * 100)/100 + 1;
        if (grossReturn < 1.0) {
           System.out.println("총 수익률은 " + Math.floor((grossReturn) * 100) / 100.0 + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임");
        }
        if (grossReturn >= 1.0) {
            System.out.println("총 수익률은 " + Math.floor((grossReturn) * 100) / 100.0 + "입니다.");
        }
    }

    private double getDoubleTotalSum() {
        BigDecimal earningAmount = BigDecimal.ZERO;
        BigDecimal fifthCount = new BigDecimal(Integer.toString(result.get(Rank.FIFTH)));
        BigDecimal fourthCount = new BigDecimal(Integer.toString(result.get(Rank.FOURTH)));
        BigDecimal thirdCount =  new BigDecimal(Integer.toString(result.get(Rank.THIRD)));
        BigDecimal secondCount =  new BigDecimal(Integer.toString(result.get(Rank.SECOND)));
        BigDecimal firstCount = new BigDecimal(Integer.toString(result.get(Rank.FIRST)));
        BigDecimal fifth = new BigDecimal("5000");
        BigDecimal fourth = new BigDecimal("50000");
        BigDecimal third = new BigDecimal("1500000");
        BigDecimal second = new BigDecimal("30000000");
        BigDecimal first = new BigDecimal("2000000000");
        BigDecimal totalSum = earningAmount.add(fifth.multiply(fifthCount)).add(fourth.multiply(fourthCount)).add(third.multiply(thirdCount)).add(second.multiply(secondCount)).add( first.multiply(firstCount));
        return totalSum.doubleValue();
    }
}
