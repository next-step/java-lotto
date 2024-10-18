package lotto.view;

import lotto.domain.LottoUnitAmount;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {


    public static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int getCount() {
           return inputNumber()/LottoUnitAmount.getIntVal();
    }
    
    public static int[] inputWinningNumber() {
        Scanner scanner = new Scanner(System.in).useDelimiter(",");
        return Arrays.stream(scanner.nextLine().replaceAll(" ", "").split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
