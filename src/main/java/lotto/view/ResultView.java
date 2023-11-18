package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class ResultView {

    private ResultView() {
    }

    public static void printResultPurchaseValue(int value) {
        System.out.println(value+"개를 구매했습니다");
        System.out.println();
    }

    public static void printResultLottoTicketValue(List<Integer> value) {
        List<Integer[]> list = new ArrayList<>();

        for (int i = 0; i < value.size(); i += 6) {
            Integer[] subArr = new Integer[6];
            for (int j = 0; j < 6; j++) {
                subArr[j] = value.get(i+j);
            }
            list.add(subArr);
        }

        for (Integer[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
