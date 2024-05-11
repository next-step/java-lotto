import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static void printBuyList(Lottos lottos) {
        StringBuilder buyList = new StringBuilder();

        buyList.append(lottos.size())
                .append("개를 구매했습니다.")
                .append("\n");

        lottos.get().forEach(lotto -> buyList.append(formatLotto(lotto))
                .append("\n"));

        System.out.println(buyList);
    }

    public static List<Integer> inputWinningNumbers() {
        clearInputBuffer();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.nextLine().replace(" ", "");

        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static void clearInputBuffer() {
        scanner.nextLine();
    }

    private static String formatLotto(Lotto lotto) {
        return lotto.numbers().get().stream()
                .map(LottoNumber::get)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return scanner.nextInt();
    }
}
