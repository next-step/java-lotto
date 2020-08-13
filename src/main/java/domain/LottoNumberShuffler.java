package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumberShuffler {
    public static final int[] shuffleNumbers = IntStream.rangeClosed(1, 45).toArray();

    public static List<Integer> getShuffleSixLottoNumber() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            list.add(shuffleNumbers[i]);
        }
        Collections.shuffle(list);
        List<Integer> result = list.subList(0, 6);
        Collections.sort(result);
        return result;
    }


}
