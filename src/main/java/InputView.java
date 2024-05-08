import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static void printBuyList(List<List<Integer>> lottos) {
        StringBuilder buyList = new StringBuilder();

        buyList.append(lottos.size()).append("개를 구매했습니다.");

        lottos.forEach(lotto -> {
            buyList.append(lotto.toString()).append("\n");
        });

        System.out.println(buyList);
    }

    public static List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = IntStream.range(0, 6)
                .mapToObj(i -> scanner.nextInt())
                .collect(Collectors.toList());

        String inputs = winningNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(inputs);

        return winningNumbers;
    }
}
