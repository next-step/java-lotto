package lotto.view;

import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static Money purchaseAmount() {
        System.out.println("구매금액을 입력해주세요.");
        Scanner in = new Scanner(System.in);
        return new Money(in.nextLong());
    }

    public static String inputLastWinningLottoNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static String inputLastBonusLottoNumbers() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static int inputManualPurchaseCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static List<String> inputManualLottoNumbers(int lottoCount) {
        if (lottoCount <= 0) {
            return new ArrayList<>();
        }

        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottoNumbersList = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            Scanner in = new Scanner(System.in);
            lottoNumbersList.add(in.nextLine());
        }
        return lottoNumbersList;
    }
}
