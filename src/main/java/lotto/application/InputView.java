package lotto.application;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int purchase() {
        System.out.println("구입 금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public int manualLottoQuantity() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public Lottos manualLottos(int count) {
        SCANNER.nextLine();
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottoList = IntStream.range(0, count)
            .mapToObj(__ -> new Lotto(SCANNER.nextLine()))
            .collect(Collectors.toList());
        return new Lottos(lottoList);
    }

    public String winningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
//        SCANNER.nextLine();
        return SCANNER.nextLine();
    }

    public int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }
}
