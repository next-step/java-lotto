package lotto.ui;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        return purchaseAmount;
    }

    public static LottoNumbers lottoWinnerNumbers() {
        System.out.println("지난주 당첨 번호를 입력해주세요");
        String winnserNumbers = scanner.nextLine();
        List<LottoNumber> list = Arrays.stream(winnserNumbers.replaceAll("\\s", "").split(","))
                .map(Integer::parseInt).map(LottoNumber::new).collect(Collectors.toList());

        return new LottoNumbers(list);
    }

    public static LottoNumber lottoBonusNumbers() {
        System.out.println("보너스볼을 입력해주세요");
        return new LottoNumber(scanner.nextInt());
    }
}
