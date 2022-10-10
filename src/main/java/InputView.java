import java.util.Scanner;

public class InputView {
    public InputValue askInput(Scanner scanner){
        String input = scanner.next();
        return new InputValue(input);
    }

}
