package lotto.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static int InputPayment() {
        System.out.println("구입금액을 입력해 주세요");
        return inputInt();
    }

    public static int InputSelfLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return inputInt();
    }

    public static List<List<Integer>> InputSelfLottoNumber(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<List<Integer>> selfLottoNumber = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            selfLottoNumber.add(Arrays.stream(new Scanner(System.in).nextLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
        }
        return selfLottoNumber;
    }

    private static int inputInt() {
        return new Scanner(System.in).nextInt();
    }
}
