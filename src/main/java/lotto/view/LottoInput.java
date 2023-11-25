package lotto.view;

import lotto.model.BonusBall;
import lotto.model.LottoNumbers;
import lotto.model.LottoNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {
    static Scanner scanner = new Scanner(System.in);

    public long getInput() {
        System.out.println("구입금액을 입력하세요.");
        return scanner.nextLong();
    }

    public BonusBall getBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new BonusBall(LottoNumber.of(scanner.nextInt()));
    }

    public LottoNumbers getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return new LottoNumbers(
                Arrays.stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .map(LottoNumber::of)
                        .collect(Collectors.toSet()));
    }
}
