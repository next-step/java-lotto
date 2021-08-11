package step2.view;

import java.util.Scanner;

public class InputView {
    public String ask(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

}
