import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getExpression() {
        System.out.println("계산할 수식을 입력하세요 (예: 2 + 3 * 4 / 2)");
        return scanner.nextLine();
    }
} 