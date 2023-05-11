package lottoauto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lottoauto.model.Constant;
import lottoauto.model.Constant.Input;

public class InputView {

    public int inputAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Input.INPUT_PRICE);
        return scanner.nextInt();
    }

    public List<Integer> inputLastWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Input.LAST_WINNING_NUMBER);
        return Arrays.stream(scanner.nextLine()
                .split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public int inputBonus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Input.INPUT_BONUS);
        return scanner.nextInt();
    }

}
