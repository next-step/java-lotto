package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private int money;
    private List<Integer> winNumbers;

    public int getMoney() {
        return money;
    }

    public void setMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        this.money = new Scanner(System.in).nextInt();
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public void setWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        this.winNumbers = Arrays.stream(new Scanner(System.in).nextLine().trim().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
