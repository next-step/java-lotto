package com.monds.nextstep.lotto.view;

import com.monds.nextstep.lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntFunction;

public class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return nextInt();
    }

    public static String lastWeeksWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return nextInt();
    }

    public static int manualLottoCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return nextInt();
    }

    public static IntFunction<List<Lotto>> manualLottos() {
        return (manualCount) -> {
            List<Lotto> lottos = new ArrayList<>();
            System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
            for (int i = 0; i < manualCount; i++) {
                lottos.add(Lotto.of(SCANNER.nextLine()));
            }
            return lottos;
        };
    }

    public static int nextInt() {
        int next = SCANNER.nextInt();
        SCANNER.nextLine();
        return next;
    }
}
