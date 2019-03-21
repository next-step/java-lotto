package lottery.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("얼마나 사실거에요?");
        return scanner.nextInt();
    }

    //TODO : 여기 고쳐야되는데 왜 이러는걸까... ㅎㅎ
    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨번호를 입력해주세요");
        scanner.nextLine().split(",");
        return convertInts(scanner.nextLine().split(","));
    }

    private static List<Integer> convertInts(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < values.length ; index++) {
            numbers.add(Integer.parseInt(values[index]));
        }
        return numbers;
    }
}
