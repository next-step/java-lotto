package view;

import domain.LottoNumber;
import domain.LottoSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class InputView {

    public static int inputBuyPrice() {

        System.out.println("구입금액을 입력해주세요");
        return new Scanner(System.in).nextInt();
    }

    public static int inputManualBuyNumber() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        return new Scanner(System.in).nextInt();
    }

    public static List<LottoSet> inputManualLottoSets(int number) {
        List<LottoSet> lottoSets = new ArrayList<>();
        if (number == 0) {
            return lottoSets;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for (int i = 0; i < number; i++) {
            lottoSets.add(LottoSet.newInstance(Arrays.stream(sc.nextLine().split(", "))
                    .map(LottoNumber::of)
                    .collect(Collectors.toList())));
        }

        return lottoSets;
    }

    public static LottoSet inputWinningLotto() {

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return LottoSet.newInstance(Arrays.stream(new Scanner(System.in).nextLine().split(", "))
                .map(LottoNumber::of)
                .collect(Collectors.toList()));

    }

    public static LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNumber.of(new Scanner(System.in).nextInt());
    }
}