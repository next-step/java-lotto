package lottery.view;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private final PrintStream out = System.out;
    private final Scanner scanner = new Scanner(System.in);

    public int getMoneyToBuy() {
        out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<String> getManualPurchases() {
        out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int numberPurchases = Integer.parseInt(scanner.nextLine());

        out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, numberPurchases)
                .mapToObj(i -> scanner.nextLine())
                .collect(Collectors.toUnmodifiableList());
    }

    public String getWinningNumber() {
        out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();
        out.println("보너스 볼을 입력해 주세요.");
        return String.join(", ", numbers, scanner.nextLine());
    }
}
