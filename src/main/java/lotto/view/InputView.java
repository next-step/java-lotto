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

    public static List<Integer> inputWinningNumber() {
        Scanner scanner = new Scanner(System.in).useDelimiter(",");
        String[] winingNumbers = scanner.nextLine().replaceAll(" ", "").split(",");
        return Arrays.stream(winingNumbers).map(Integer::parseInt).collect(Collectors.toList());
    }
}
