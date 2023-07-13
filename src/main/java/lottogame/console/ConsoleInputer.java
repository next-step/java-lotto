package lottogame.console;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.console.util.LocalScanner;
import lottogame.controller.spi.Inputer;

public class ConsoleInputer implements Inputer {

    @Override
    public int inputMoney() {
        LocalScanner localScanner = LocalScanner.getInstance();
        System.out.println("구입금액을 입력해 주세요.");
        return localScanner.nextInt();
    }

    @Override
    public Set<Integer> inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return Arrays.stream(LocalScanner.getInstance().nextLine().split(","))
            .map(string -> Integer.valueOf(string.strip()))
            .collect(Collectors.toSet());
    }

    @Override
    public Integer inputBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LocalScanner.getInstance().nextInt();
    }
}
