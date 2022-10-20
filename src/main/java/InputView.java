import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = " ";

    public void validInputText(String text) {
        if (text == null || text.isEmpty() || text.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getUserInputToStringList() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        validInputText(input);
        return Arrays.asList(scanner.nextLine().split(DELIMITER));
    }


}
