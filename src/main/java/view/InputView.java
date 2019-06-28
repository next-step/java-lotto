package view;

import domain.LottoNumber;
import domain.LottoSet;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static int inputBuyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static LottoSet inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new LottoSet(Arrays.stream(new Scanner(System.in).nextLine().split(","))
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(new Scanner(System.in).nextInt());
    }
}
