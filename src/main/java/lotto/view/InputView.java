package lotto.view;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.Lotto;

public class InputView {

    private final static String LOTTO_INIT_MESSAGE = "구입금액을 입력해 주세요.\n";
    private final static String LAST_WEEK_LOTTO_INIT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.\n";

    private final Scanner scanner;
    private final PrintStream sout;

    public InputView(Scanner scanner, PrintStream sout) {
        this.scanner = scanner;
        this.sout = sout;
    }

    public int lottoInitCount() {
        sout.print(LOTTO_INIT_MESSAGE);
        return scanner.nextInt();
    }

    public List<Integer> lastWeakLottoInit() {
        List<Integer> integerList = new ArrayList<>();
        sout.print(LAST_WEEK_LOTTO_INIT_MESSAGE);
        scanner.skip("\n");
        String string = scanner.nextLine().replaceAll(" ", "");
        for (String s : string.split(",")) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }
}
