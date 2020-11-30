package step2;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getResultNumber(){
        return getAnswer("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static int getMoney(){
        return Integer.parseInt(getAnswer("구입금액을 입력해 주세요"));
    }

    private static String getAnswer(String text){
        System.out.println(text);
        return scanner.nextLine();
    }
}
