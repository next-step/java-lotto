package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BroadCast {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_REGEX = ", ";


    public static List<Integer> pickNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winNumberString = scanner.nextLine();
        return Arrays.stream(winNumberString.split(SPLIT_REGEX)).map(Integer::parseInt).collect(Collectors.toList());
    }
}
