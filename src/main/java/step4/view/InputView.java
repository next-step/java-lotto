package step4.view;

import step4.domian.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final String BUY_TEXT = "구입금액을 입력해 주세요.";
    public static final String LAST_WINNER_TEXT = "지난 주 당첨 번호를 입력해 주세요";
    public static final String LAST_BONUS_TEXT = "보너스 볼을 입력해 주세요.";

    public static final String MANUAL_NUM_TEXT = "수동으로 구매할 로또 수를 입력해 주세요.";

    public static final String MANUAL_LOTTO_TEXT = "수동으로 구매할 번호를 입력해 주세요.";
    public static final Scanner sc = new Scanner(System.in);

    public static int buyLotto() {
        System.out.println(BUY_TEXT);
        return sc.nextInt();
    }

    public static int inputManualNum() {
        sc.nextLine();
        System.out.println("\n" + MANUAL_NUM_TEXT);
        return sc.nextInt();
    }

    public static List<Lotto> inputManualLottos(int num) {
        sc.nextLine();
        System.out.println("\n" + MANUAL_LOTTO_TEXT);

        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            manualLottos.add(new Lotto(Arrays.stream(sc.nextLine().replace(" ", "").split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList())));
        }
        return manualLottos;
    }

    public static List<Integer> inputLastWinner() {
        System.out.println("\n" + LAST_WINNER_TEXT);
        return Arrays.stream(sc.nextLine().replace(" ", "").split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    public static int inputLastBonus() {
        System.out.println(LAST_BONUS_TEXT);
        return sc.nextInt();
    }
}
