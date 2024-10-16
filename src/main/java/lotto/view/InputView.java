package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {


    public static int getCount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt() / 1000;
    }

    public static String[] inputWinningNumber() {
        Scanner scanner = new Scanner(System.in).useDelimiter(",");
        return scanner.nextLine().replaceAll(" ", "").split(",");
    }
}
