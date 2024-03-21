package step2.view;

import step2.Lotto;
import step2.LottoNumber;
import step2.LottoStore;
import step2.Lottos;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static void printLottoList(LottoStore lottoStore) {
        System.out.println(lottoStore + "개를 구매했습니다.");
        Lottos lottos = lottoStore.getLottos();
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumberString());
        }
    }

    public static String inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
