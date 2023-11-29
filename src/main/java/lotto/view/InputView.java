package lotto.view;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private final static String LOTTO_INIT_MESSAGE = "구입금액을 입력해 주세요.\n";
    private final static String LAST_WEEK_LOTTO_INIT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.\n";
    private final static String BONUS_BALL_INIT_MESSAGE = "보너스 볼을 입력해 주세요.\n";
    private static final String MANUALLY_COUNT_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.\n";
    private static final String MANUALLY_LOTTO_INIT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.\n";

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

    public List<Integer> lastWeekLottoInit() {
        List<Integer> integerList = new ArrayList<>();
        sout.print(LAST_WEEK_LOTTO_INIT_MESSAGE);
        String string = scanner.nextLine().replaceAll(" ", "");
        for (String s : string.split(",")) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }

    public int bonusBallInit() {
        sout.print(BONUS_BALL_INIT_MESSAGE);
        int bonusBall = scanner.nextInt();
        sout.print("\n");
        return bonusBall;
    }

    public List<List<String>> manuallyLottoInit() {
        sout.print(MANUALLY_COUNT_INPUT_MESSAGE);
        int count = scanner.nextInt();
        scanner.skip("\n");
        sout.print(MANUALLY_LOTTO_INIT_MESSAGE);

        return IntStream.range(0, count)
            .mapToObj(i -> List.of(scanner.nextLine().replaceAll(" ", "").split(",")))
            .collect(Collectors.toList());
    }
}
