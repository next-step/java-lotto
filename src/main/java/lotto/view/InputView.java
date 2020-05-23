package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static int requestPrice() {
        System.out.println("구입급액을 입력해주세요.");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        }catch (NumberFormatException e){
            System.out.println("입력을 확인해주세요.");
            return requestPrice();
        }
    }

    public static List<List<Integer>> requestManualNumsList() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int count = 0;
        try {
            count = Integer.parseInt(scanner.nextLine().trim());
            if(count < 0){
               throw new  NumberFormatException();
            }

        }catch (NumberFormatException e){
            System.out.println("입력을 확인해주세요.");
            return requestManualNumsList();
        }

        if(count == 0){
            return Collections.EMPTY_LIST;
        }

        return getManualNumsList(count);
    }

    private static List<List<Integer>> getManualNumsList(int count) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        return Stream.generate(() -> {
            String nums = scanner.nextLine();
            return Arrays.stream(nums.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        }).limit(count).collect(Collectors.toList());
    }

    public static List<Integer> requestWinNums() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winNums = scanner.nextLine();

        return Arrays.stream(winNums.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }


    public static Integer requestBonusNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        }catch (NumberFormatException e){
            System.out.println("입력을 확인해주세요.");
            return requestBonusNum();
        }
    }
}
