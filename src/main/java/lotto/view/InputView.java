package lotto.view;

import lotto.model.Lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";

    private Scanner scanner = new Scanner(System.in);

    public int getMoney() {
        System.out.println("얼마를 살것인가?");
        return scanner.nextInt();
    }

    public Lotto getWinningLotto() {
        scanner.nextLine();
        System.out.println("지난 로또 당첨 번호");
        String input = scanner.nextLine();

        return new Lotto(Arrays.stream(input.split(DELIMITER))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList()));
    }
}
