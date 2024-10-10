package view;

import model.LottoStatistics;

import java.util.List;

public class ResultView {
    public static void printResult(int result) {
        System.out.println("계산 결과 : " + result);
    }

    public static void printNumberOfLotto(int totalPrice, int priceOfALotto) {
        if (priceOfALotto <= 0) {
            throw new IllegalArgumentException("priceOfALotto must be greater than 0");
        }
        int cnt = totalPrice / priceOfALotto;
        System.out.println(cnt + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<List<Integer>> numbers) {
        for (List<Integer> number : numbers) {
            System.out.println(number);
        }
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (5000원)- ")
                .append(lottoStatistics.getCountOfPrize3())
                .append("개")
                .append("\n")
                .append("4개 일치 (50000원)- ")
                .append(lottoStatistics.getCountOfPrize4())
                .append("개")
                .append("\n")
                .append("5개 일치 (1500000원)- ")
                .append(lottoStatistics.getCountOfPrize5())
                .append("개")
                .append("\n")
                .append("6개 일치 (2000000000원)- ")
                .append(lottoStatistics.getCountOfPrize6())
                .append("개")
                .append("\n")
                .append("총 수익률은 ")
                .append(lottoStatistics.getNetIncome())
                .append("입니다.")
                .append("(기준이 1이기 때문에 결과적으로 ")
                .append(lottoStatistics.getNetIncome() < 1.0 ? "손해" : "이익")
                .append("라는 의미임)");
        System.out.println(sb);

    }
}
