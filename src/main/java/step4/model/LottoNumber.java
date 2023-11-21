package step4.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private final List<Integer> allLottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    public List<Integer> getShufflingNumbers() {
        Collections.shuffle(this.allLottoNumbers);
        return this.allLottoNumbers.subList(0, 6);
    }
}
