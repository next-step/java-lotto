package step3.view.Input;

import java.util.Scanner;

public class IntegerInputProcessor extends InputProcessor<Integer>{

    @Override
    public Integer process(Scanner scanner) {
        return scanner.nextInt();
    }
}
