package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoResultInputView {
    public static final String DELIMITER = ",";

    private List<Integer> winNumbers;
    private int bonusNumber;

    public void setWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        this.winNumbers = Arrays.stream(new Scanner(System.in).nextLine()
                .split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void setBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        this.bonusNumber = new Scanner(System.in).nextInt();
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
