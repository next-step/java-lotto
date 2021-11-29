package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private static Scanner SCANNER = new Scanner(System.in);

    private static Integer PRICE_PER_LOTTO = 1000;

    public static Integer inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer purchaseAmount = SCANNER.nextInt();
        SCANNER.nextLine();
        return purchaseAmount;
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static LottoNumber inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        LottoNumber bonusBall = LottoNumber.ofInt(SCANNER.nextInt());
        SCANNER.nextLine();
        return bonusBall;
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = SCANNER.nextInt();
        SCANNER.nextLine();
        return manualLottoCount;
    }

    public static Lottos inputManualLottos(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < manualLottoCount; index++) {
            lottoList.add(Lotto.ofString(SCANNER.nextLine()));
        }
        Lottos lottos = Lottos.ofLottoList(lottoList);
        return lottos;
    }
}