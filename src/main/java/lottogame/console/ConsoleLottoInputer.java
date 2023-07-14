package lottogame.console;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsoleLottoInputer implements lottogame.controller.spi.LottoInputer {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    @Override
    public Set<Integer> inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return Arrays.stream(scanner.nextLine().split(","))
                .map(string -> Integer.valueOf(string.strip()))
                .collect(Collectors.toSet());
    }

    @Override
    public Integer inputBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
