public class ResultView {
    public static void prntLottoCount(Money money){
        System.out.println(money.availLottoCount() + "개를 구매했습니다.");
    }

    public static void prntTotalCandidates(int manualLottoCount, int autoLottoCount, Candidates candidates) {
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다.");

        System.out.println(candidates.toString());
    }

    public static void prntStatistics(CandidateRanks ranks) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        System.out.println("3개 일치 (5000원)- " + ranks.countFifth() + "개");
        System.out.println("4개 일치 (50000원)- " + ranks.countFourth() + "개");
        System.out.println("5개 일치 (1500000원)- " + ranks.countThird() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + ranks.countSecond() + "개");
        System.out.println("6개 일치 (2000000000원)- " + ranks.countFirst() + "개");
        System.out.println("총 수익률은 " + ranks.calcBenefitPercent());
    }
}
