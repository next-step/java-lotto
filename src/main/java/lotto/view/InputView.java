package lotto.view;

import lotto.StringParser;

import java.util.Scanner;
import java.util.Set;

public class InputView {

    private int purchasePrice;
    private Set<Integer> winningNumbers;
    private final Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public void inputPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = sc.nextLine();

        try {
            purchasePrice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자 외에 입력할 수 없습니다.");
            e.printStackTrace();
        }
    }

    public void inputWinningNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = sc.nextLine();
        winningNumbers = StringParser.getParseNumbers(input);
        System.out.println();
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
