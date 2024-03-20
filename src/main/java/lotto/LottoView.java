package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구매금액을 입력해주세요");
        int price = scanner.nextInt();
        scanner.nextLine();
        int lottoCount = getLottoCount(price);
        System.out.println(lottoCount + "개를 구매했습니다.");
        LottoGame lottoGame = new LottoGame(lottoCount, new RandomLottoGeneration());
        List<Lotto> lottoList = lottoGame.getLottos();

        createLottoListView(lottoList);

        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Lotto winnerLotto = createWinnerLotto(scanner);

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + LottoPrize.FOURTH.getMatchCount(winnerLotto, lottoList) + "개");
        System.out.println("4개 일치 (50000원)- " + LottoPrize.THIRD.getMatchCount(winnerLotto, lottoList) + "개");
        System.out.println("5개 일치 (1500000원)- " + LottoPrize.SECOND.getMatchCount(winnerLotto, lottoList) + "개");
        System.out.println("6개 일치 (2000000000원) " + LottoPrize.FIRST.getMatchCount(winnerLotto, lottoList) + "개");

        double rateOfReturn = getRateOfReturn(price, lottoList, winnerLotto);
        System.out.println("총 수익률은 " + String.format("%.2f", rateOfReturn) + "입니다.(기준이 1이기 때문에 결과적으로 " + resultString(rateOfReturn) + "라는 의미임)")
        ;

    }

    private static void createLottoListView(List<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println(lottoList.get(i));
        }
    }

    private static String resultString(double rateOfReturn) {
        if (rateOfReturn > 1) {
            return "이득이";
        }

        if (rateOfReturn == 1) {
            return "본전이";
        }

        return "손해";
    }

    private static double getRateOfReturn(double price, List<Lotto> lottoList, Lotto winnerLotto) {
        return LottoPrize.getPrizeSum(winnerLotto, lottoList) / price;
    }

    private static Lotto createWinnerLotto(Scanner scanner) {
        String s = scanner.nextLine();
        String[] stringSplit = s.split(", ");
        return Lotto.create(() -> Arrays.stream(stringSplit).map(str -> Integer.valueOf(str)).collect(Collectors.toList()));
    }

    private static int getLottoCount(int price) {
        return price / LottoGame.LOTTO_PRICE();
    }
}
