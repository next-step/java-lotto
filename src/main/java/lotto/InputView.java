package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.*;

public class InputView {

    private static final Scanner reader = new Scanner(in);

    public static int receiveMoney() {
        out.println("구매금액을 입력해 주세요.");
        return nextInt();
    }

    private static int nextInt() {
        int readInt = reader.nextInt();
        reader.nextLine();
        return readInt;
    }


    public static int[] receiveWinningLottoNumbers() {
        out.println("지난 주 당첨 번호를 입력해 주세요.");
        return receiveNumbers();
    }

    private static int[] receiveNumbers() {
        return Arrays.stream(reader.nextLine().split(","))
                .map(String::strip)
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int receiveBonusNumber() {
        out.println("보너스 볼을 입력해 주세요.");
        return nextInt();
    }

    public static int receiveManualTicketCount() {
        out.println("수동으로 구매할 로또 수를 입력해 주세요.\n");
        return nextInt();
    }

    public static int[][] lottoTickets(int manualTicketCount) {
        out.println("수동으로 구매할 번호를 입력해 주세요.\n");
        return IntStream.range(0, manualTicketCount)
                .mapToObj(i -> receiveNumbers())
                .toArray(int[][]::new);
    }
}
