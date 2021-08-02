package step2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoNumberGenerator {

    private LottoNumberGenerator() {
    }

    private static final List<Integer> lottoNumberList = new ArrayList<>();

    public static List<Integer> create() {
        if (lottoNumberList.isEmpty()) {
            createLottoNumbers();
        }

        Collections.shuffle(lottoNumberList);
        List<Integer> numbers = new ArrayList<>(lottoNumberList.subList(0, 6));
        numbers.sort(Comparator.naturalOrder());
        return numbers;

    }

    private static void createLottoNumbers() {
        for (int i = 1; i < 46; i++) {
            lottoNumberList.add(i);
        }
    }
}
