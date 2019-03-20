
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static Lotto getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(Arrays.stream(new Scanner(System.in).nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));
    }
}
