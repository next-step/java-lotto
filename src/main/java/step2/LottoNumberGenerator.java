package step2;

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
        List<Integer> integers = lottoNumberList.subList(0, 6);
        integers.sort(Comparator.naturalOrder());
        return integers;

    }

    private static void createLottoNumbers() {
        for (int i = 1; i < 46; i++) {
            lottoNumberList.add(i);
        }
    }
}
