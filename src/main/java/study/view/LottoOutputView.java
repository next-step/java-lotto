package study.view;

import java.util.Arrays;
import java.util.List;

import study.calculator.SentenceCalculator;

public class LottoOutputView {

    private int purchasedPrice = 0;
    private List<Integer> prices = Arrays.asList(
        0, 0, 5000, 50000, 1500000, 2000000000
    );

    private int totalEarningPrice = 0;

    private List<Integer> winners;

    public LottoOutputView(List<Integer> winners, int purchasedPrice) {
        this.winners = winners;
        this.purchasedPrice = purchasedPrice;
        calculatePrice();
    }

    public void calculatePrice() {
        for (int i = 2; i < 6; i++) {
            String earning = prices.get(i) + " * " + this.winners.get(i);
            int resultByPrice = new SentenceCalculator(earning).doCalculate();

            String addTotalSentence = totalEarningPrice + " + " + resultByPrice;
            totalEarningPrice = new SentenceCalculator(addTotalSentence).doCalculate();
        }
    }

    public void getWinnerStatic() {
        System.out.println("당첨통계");
        System.out.println("--------------");
        System.out.println("3개 일치 (5000원) - " + winners.get(2) + "개");
        System.out.println("4개 일치 (50000원) - " + winners.get(3) + "개");
        System.out.println("5개 일치 (1500000원) - " + winners.get(4) + "개");
        System.out.println("6개 일치 (2000000000원) - " + winners.get(5) + "개");

        double result = (double)totalEarningPrice / (double)purchasedPrice;
        String formattedResult = String.format("%.2f", result);
        System.out.println("총 수익률은 " + formattedResult + "입니다.");
    }
    
}
