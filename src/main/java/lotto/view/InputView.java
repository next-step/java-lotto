package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinnerNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);


    public static final int inputPurchaseAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static final WinnerNumbers inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] split = SCANNER.next().split(",");

        List<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        LottoNumbers lottoNumbers = new LottoNumbers(list);

        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = SCANNER.nextInt();

        return new WinnerNumbers(lottoNumbers, LottoNumber.valueOf(bonusNumber));
    }

    private InputView() {}
}
