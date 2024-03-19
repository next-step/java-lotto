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
        int lottoCount = getLottoCount(price);
        System.out.println(lottoCount + "개를 구매했습니다.");
        LottoGame lottoGame = new LottoGame(lottoCount, new RandomLottoGeneration());
        List<Lotto> lottoList = lottoGame.getLottos();

        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println(lottoList.get(i));
        }
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String s = scanner.nextLine();
        String[] stringSplit = s.split(", ");
        List<Integer> winnerLotto = Arrays.stream(stringSplit).map(str -> Integer.valueOf(str)).collect(Collectors.toList());

    }

    private static int getLottoCount(int price) {
        return price / LottoGame.LOTTO_PRICE;
    }
}
