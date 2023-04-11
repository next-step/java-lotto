package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final int INITIAL_VALUE = 0;
    private final Scanner scanner = new Scanner(System.in);
    int amount = INITIAL_VALUE;
    int count = INITIAL_VALUE;

    private List<Integer> winningNumbers = null;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void saveAmount() {
        System.out.println("구입 금액을 입력해 주세요");
        amount = scanner.nextInt();
        clearScannerBuffer();
    }

    public void saveCount() {
        count = getCount();
        System.out.println(count + "개를 구매했습니다.");
    }

    public void saveWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String str = scanner.nextLine();
        clearScannerBuffer();
        winningNumbers = new ArrayList<>(toInts(split(str)));

    }

    private void clearScannerBuffer() {
        scanner.nextLine();
    }

    private String[] split(String str) {
        return str.split(",");
    }

    private List<Integer> toInts(String[] strArray) {
        List<Integer> ints = new ArrayList<>();
        for (String str : strArray) {
            ints.add(Integer.parseInt(str.trim()));
        }
        return ints;
    }

    private int getCount() {
        return amount/1000;
    }

}
