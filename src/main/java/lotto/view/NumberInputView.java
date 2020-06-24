package lotto.view;

import java.util.Scanner;

public class NumberInputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final String lottoNumbers;
    private final int bonusNumber;

    private NumberInputView(String lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static NumberInputView enterWinningLottoNumbers() {
        return new NumberInputView(getWinningInput(), getBonusInput());
    }

    private static String getWinningInput() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    private static int getBonusInput() {
        System.out.println("보너스 볼을 입력해주세요.");
        return SCANNER.nextInt();
    }

    public String getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
