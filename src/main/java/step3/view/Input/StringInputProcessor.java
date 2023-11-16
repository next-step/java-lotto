package step3.view.Input;

import java.util.Scanner;

public class StringInputProcessor extends InputProcessor<String>{
    @Override
    public String process(Scanner scanner) {
        return scanner.nextLine();
    }
}
