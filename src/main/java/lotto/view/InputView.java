package lotto.view;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {
    private Scanner scanner;

    public InputView(InputStream is) {
        this.scanner = new Scanner(is);
    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        return this.scanner.nextInt();
    }

    public List<Integer> inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        StringTokenizer stringTokenizer =
                new StringTokenizer(this.scanner.nextLine(), ",");
        List<Integer> inputNumberList = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            inputNumberList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        return inputNumberList;
    }
}
