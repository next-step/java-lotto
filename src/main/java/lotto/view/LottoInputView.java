package lotto.view;

import java.util.Scanner;

public class LottoInputView {
    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public String inputStringLine(String question) {
        System.out.println(question);
        return scanner.next();
    }

    public int inputAmount(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }
}
