package ui;

import lotto.BonusNumber;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final int INITIAL_VALUE = 0;
    private final Scanner scanner = new Scanner(System.in);
    int amount = INITIAL_VALUE;
    int autoCount = INITIAL_VALUE;
    int manualCount = INITIAL_VALUE;

    private Lotto winningNumbers = null;
    public List<Lotto> manualLottos = new ArrayList<>();

    private BonusNumber bonusNumber = null;

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber(){
        return bonusNumber;
    }

    public void saveAmount() {
        System.out.println("구입 금액을 입력해 주세요");
        amount = scanner.nextInt();
        clearScannerBuffer();
    }

    public void saveManualCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해주세요");
        manualCount = scanner.nextInt();
        clearScannerBuffer();
    }

    public void saveManualLottos() {
        System.out.println("수동으로 구매할 번호를 입력해주세요");
        for (int i = 0; i < manualCount; i++) {
            String str = scanner.nextLine();
            manualLottos.add(new Lotto(toInts(split(str))));
        }
    }

    public void saveAutoCount() {
        autoCount = calculateAutoCount();
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + autoCount + "장을 구매했습니다.");
    }

    public void saveWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String str = scanner.nextLine();
        winningNumbers = new Lotto(toInts(split(str)));
    }

    public void saveBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요");
        int number = scanner.nextInt();
        bonusNumber = new BonusNumber(number);
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

    private int calculateAutoCount() {
        return (amount - (manualCount * 1000)) / 1000;
    }

}
