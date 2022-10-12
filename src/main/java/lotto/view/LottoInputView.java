package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.util.StringToIntUtil;

public class LottoInputView {

    private static final String WIN_SEPARATOR = ", ";

    private static final Scanner scanner = new Scanner(System.in);

    private LottoInputView() {
    }

    public static int getAmount() {
        System.out.println("구입금액을 입력해주세요.");
        String text = scanner.nextLine();
        return StringToIntUtil.apply(text);
    }

    public static List<Integer> getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String text = scanner.nextLine();
        return splitText(text);
    }

    private static List<Integer> splitText(String text) {
        String[] texts = text.split(WIN_SEPARATOR);
        List<Integer> numbers = new ArrayList<>();
        for (String str : texts) {
            numbers.add(StringToIntUtil.apply(str));
        }
        return numbers;
    }
}
