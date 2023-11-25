package camp.nextstep.edu.lottery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readInt();
    }

    public static String inputWinningLotteryNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return readLine();
    }

    private static int readInt() {
        return Integer.parseInt(readLine());
    }

    private static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
