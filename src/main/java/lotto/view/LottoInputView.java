package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.util.StringToIntUtil;

public class LottoInputView {

    private static final String SEPARATOR = ", ";

    private static final Scanner scanner = new Scanner(System.in);

    private LottoInputView() {
    }

    public static int getAmount() {
        System.out.println("구입금액을 입력해주세요.");
        String text = scanner.nextLine();
        return StringToIntUtil.apply(text);
    }

    public static int getManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String text = scanner.nextLine();
        return StringToIntUtil.apply(text);
    }

    public static List<Integer> getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String text = scanner.nextLine();
        return splitText(text);
    }

    public static LottoBall getBonusBallNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        int number = scanner.nextInt();
        return LottoBall.from(number);
    }

    private static List<Integer> splitText(String text) {
        String[] texts = text.split(SEPARATOR);
        List<Integer> numbers = new ArrayList<>();
        for (String str : texts) {
            numbers.add(StringToIntUtil.apply(str));
        }
        return numbers;
    }

    public static List<Lotto> getManualLottos(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            String text = scanner.nextLine();
            lottos.add(new Lotto(textToInteger(text)));
        }
        return lottos;
    }

    private static List<Integer> textToInteger(String text) {
        return Arrays.stream(text.split(SEPARATOR))
                .map(StringToIntUtil::apply)
                .collect(Collectors.toList());
    }
}
