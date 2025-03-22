import java.util.Scanner;

public class InputProcessor {
    private static final Scanner scanner = new Scanner(System.in);

    public UserInput getInput() {
        return UserInput.fromStringInput(scanner.nextLine());
    }
}
