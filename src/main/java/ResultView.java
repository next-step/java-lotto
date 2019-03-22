import java.util.Arrays;

public class ResultView {

    public static void printBuyLotto(int number) {
        System.out.println(number + "개를 구입하였습니다.");
    }

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printStatics(LottoResult lottoResult) {
        Rank[] ranks = Rank.values();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(ranks)
                .filter(rank -> rank.getCountOfMatch() != 0)
                .forEach(rank -> {
                    System.out.println(rank.getCountOfMatch()
                            + "개 일치 (" + rank.getWinningMoney() + ") - "
                            + lottoResult.getMatchNumber(rank));
                });

        System.out.println("총 수익률은 " + lottoResult.getProfit() + "입니다.");
    }
}
