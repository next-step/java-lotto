import java.io.PrintStream;
import java.util.Scanner;

public class InputView {

    private final static String CALCULATE_INIT_MESSAGE = "값을 입력해주세요.";

    private final Scanner scanner;
    private final PrintStream sout;
    public InputView(Scanner scanner, PrintStream sout) {
        this.scanner = scanner;
        this.sout = sout;
    }

    public String calculatorString(){
        sout.println(CALCULATE_INIT_MESSAGE);
        return scanner.nextLine();
    }
}
