package lotto;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

public class InputView {

    private static final Scanner reader = new Scanner(in);

    public static int receiveMoney() {
        out.println("구매금액을 입력해 주세요.");
        return reader.nextInt();
    }


    public static int[] receiveWinningLottoNumbers() {
        out.println("지난 주 당첨 번호를 입력해 주세요.");
        reader.nextLine();
        return Arrays.stream(reader.nextLine().split(","))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int receiveBonusNumber() {
        out.println("보너스 볼을 입력해 주세요.");
        return reader.nextInt();
    }
}
