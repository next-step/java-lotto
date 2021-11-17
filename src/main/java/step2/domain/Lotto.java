package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int SIZE = 6;

    private static List<Integer> NumberList = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    private final List<Integer> lottoNumbers;

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public Lotto() {
        Collections.shuffle(NumberList);
        this.lottoNumbers = new ArrayList<>(NumberList.subList(0, SIZE));
    }

    public Integer checkMatching(List<Integer> winningNumbers) {
        Long count = lottoNumbers.stream().filter(i->winningNumbers.contains(i)).count();
        return count.intValue();
    }

}
