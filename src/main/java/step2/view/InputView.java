package step2.view;

import static step2.view.Messages.REQUEST_LAST_WEEK_WINNING_NUMBER;
import static step2.view.Messages.REQUEST_PRICE;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputPrice() {
        System.out.println(REQUEST_PRICE);
        return scanner.nextInt();
    }

    public String inputLastWeekWinningNumbers() {
        System.out.println(REQUEST_LAST_WEEK_WINNING_NUMBER);
        return scanner.nextLine();
    }
}
