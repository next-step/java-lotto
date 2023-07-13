package lottogame.console.resultcheck;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.console.util.LocalScanner;
import lottogame.controller.resultcheck.spi.ResultCheckInputer;

public class ConsoleResultCheckInputer implements ResultCheckInputer {

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
