import java.util.List;

public class ResultView {

    public static void printBuyLotto(int number) {
        System.out.println(number + "개를 구입하였습니다.");
    }

    public static void printLottoNumber(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public static void printStatics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottoResult.getMatchNumber(3));
        System.out.println("4개 일치 (50000원)- " + lottoResult.getMatchNumber(4));
        System.out.println("5개 일치 (1500000원)- " + lottoResult.getMatchNumber(5));
        System.out.println("6개 일치 (2000000000원)-" + lottoResult.getMatchNumber(6));
        System.out.println("총 수익률은 " + lottoResult.getProfit() + "입니다.");
    }
}
