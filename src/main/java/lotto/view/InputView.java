package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public int getLottoBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getManualLottoNumber() {
        System.out.println("구입금액을 수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<String> getManualLotto(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, count)
                        .mapToObj(i -> scanner.nextLine())
                        .collect(Collectors.toList());
    }

    public String getLottoWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public String getBouns() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
