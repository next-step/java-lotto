package autoLotto;

public class OutputView {

    public static void outputQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void outputLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto());
        }
    }

    public static void outputResult(GameResult gameResult) {
        double result = gameResult.getResult();

        System.out.println("\n당첨 통계\n" +
                "---------");
        System.out.println("3개 일치 (5000원)-"+ gameResult.getFifthRank() + "개");
        System.out.println("4개 일치 (50000원)-"+ gameResult.getFourthRank() + "개");
        System.out.println("5개 일치 (1500000원)-"+ gameResult.getThirdRank() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)-" + gameResult.getSecondRank() + "개");
        System.out.println("6개 일치 (2000000000원)-"+ gameResult.getFirstRank() + "개");
        System.out.print("총 수익률은 " + result +"입니다.");
        if (result < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
