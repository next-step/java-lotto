import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String inputString(){

        System.out.println("공백 기준으로 나누어 숫자와 사칙 연산자를 입력 하세요:");
        return SCANNER.nextLine();
    }
}
