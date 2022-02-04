package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public class LottoInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInput() {
    }

    public static int inputPrice() {
        System.out.println("구입금액을 입력해주세요");
        return SCANNER.nextInt();
    }

    public static LottoNumbers inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        String input = SCANNER.next();
        return new LottoNumbers(Arrays.stream(input.split(","))
            .mapToInt(Integer::new)
            .boxed()
            .collect(Collectors.toList()));
    }

    public static LottoNumber inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = SCANNER.nextInt();
        return new LottoNumber(bonusBall);
    }
}
