package lottoauto.view;

import java.util.Scanner;

public class InputView {
    public int inputAmount(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextInt();
    }

    public String inputLastWinningNumber(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextLine();
    }

}
