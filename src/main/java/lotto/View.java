package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        PlayLotto playLotto = new PlayLotto();
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int lottoCount = playLotto.buyLotto(scanner.nextInt());

        System.out.println(lottoCount + "개를 구매했습니다.");
        lotto.createLottoNumbers();
        lotto.getLottos(lottoCount);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        String[] lastNumbers = scanner.nextLine().replaceAll(" ", "").split(",");

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        System.out.println("당첨 통계");
        System.out.println("---------------");

        lotto.compareNumber();
    }
}
