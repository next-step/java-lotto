import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            winningNumbers.add(scanner.nextInt());
        }
        return winningNumbers;
    }
}
