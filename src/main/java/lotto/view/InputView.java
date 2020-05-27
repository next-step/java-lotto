package lotto.view;

import java.util.Scanner;

public class InputView {

    private int totalPrice;
    private String winningNumbers;
    private final Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public void inputTotalPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        totalPrice = sc.nextInt();
    }

    public void inputWinningNumbers(){
        System.out.println("구입금액을 입력해 주세요.");
        winningNumbers = sc.nextLine();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }
}
