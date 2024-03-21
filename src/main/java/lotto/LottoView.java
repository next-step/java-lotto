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
        createLottoListView(lottoGame);

        System.out.println("\n 지난 주 당첨 번호를 입력해 주세요.");
        Lotto winnerLotto = createWinnerLotto(scanner);

        ResultView.createLottoResultView(lottoGame, winnerLotto);
    }

    private static void createLottoListView(LottoGame lottoGame) {
        List<Lotto> lottoList = lottoGame.getLottos();
        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println(lottoList.get(i));
        }
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
