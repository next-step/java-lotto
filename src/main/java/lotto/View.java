package lotto;

import java.util.List;
import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        LottoCreator lottoCreator = new LottoCreator();
        LottoPurchase lottoPurchase = new LottoPurchase();
        LottoNumbers numbers = new LottoNumbers();
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int lottoCount = lottoPurchase.buyLotto(scanner.nextInt());
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Integer> lottoNumbers = numbers.lottoNumbers;
        lottoCreator.buyLottos(lottoCount,lottoNumbers);
//        lottoCreator.shuffleLottoNumbers();
//        lotto.getLottos(lottoCount);
//
//        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
//        scanner.nextLine();
//        String[] lastNumbers = scanner.nextLine().replaceAll(" ", "").split(",");
//        lotto.lastWeekNumber(lastNumbers);
//
//        System.out.println("보너스 번호를 입력해 주세요.");
//        int bonusNumber = scanner.nextInt();
//
//        System.out.println("당첨 통계");
//        System.out.println("---------------");
    }
}
