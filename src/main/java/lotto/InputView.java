package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<LottoNumber> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();

        return Arrays.stream(nums.split(",")).map(String::trim)
            .map(Integer::parseInt).map(LottoNumber::new).collect(
                Collectors.toList());
    }
}
