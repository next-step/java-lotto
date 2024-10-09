package view;

import model.LottoStatistics;

public class ResultView {
    public static void printResult(int result) {
        System.out.println("계산 결과 : " + result);
    }

    public static void printNumberOfLotto(int cnt) {
        System.out.println(cnt + "개를 구매했습니다.");
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (5000원)- ")
                .append(lottoStatistics.getCnt3())
                .append("개")
                .append("4개 일치 (50000원)- ")
                .append(lottoStatistics.getCnt4())
                .append("개")
                .append("5개 일치 (1500000원)- ")
                .append(lottoStatistics.getCnt5())
                .append("개")
                .append("6개 일치 (2000000000원)- ")
                .append(lottoStatistics.getCnt6())
                .append("개")
                .append("총 수익률은 ")
                .append(lottoStatistics.getNetIncome())
                .append("입니다.")
                .append("(기준이 1이기 때문에 결과적으로 ")
                .append(lottoStatistics.getNetIncome() == 0.0 ? "이익 없음" : lottoStatistics.getNetIncome() < 1.0 ? "손해" : "이익")
                .append("라는 의미임)");
        System.out.println(sb);

    }
}
