package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);


    public static final int inputPurchaseAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static final LottoNumbers inputLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] split = new Scanner(System.in).nextLine().split(",");

        Set<LottoNumber> set = new HashSet<>();
        for (String s : split) {
            set.add(new LottoNumber(Integer.parseInt(s)));
        }

        return new LottoNumbers(set);
    }
}
