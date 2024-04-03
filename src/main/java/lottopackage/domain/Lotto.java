package lottopackage.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {



    /* Variables */
    public static List<Integer> totalLottoNumber = new ArrayList<>(
            Arrays.stream(IntStream.rangeClosed(1, 45).toArray()).boxed().collect(Collectors.toList()));

    List<Integer> lottoNumber;

    /* Constructor */
    public Lotto() {
        Collections.shuffle(totalLottoNumber);
        lottoNumber = new ArrayList<>(totalLottoNumber.subList(0, 6));
    }

    public Lotto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    /* Getter */
    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public static List<Integer> getTotalLottoNumber() {
        return totalLottoNumber;
    }

    /* Method */
    public Prize isPrize(List<Integer> winningNumber) {
        List<Integer> matchedLottoNumber = new ArrayList<>(lottoNumber);
        matchedLottoNumber.removeAll(winningNumber);
        if (matchedLottoNumber.isEmpty()) {
            return Prize.FIRST;
        }
        if (matchedLottoNumber.size() == 1) {
            return Prize.THIRD;
        }
        if (matchedLottoNumber.size() == 2) {
            return Prize.FOURTH;
        }
        if (matchedLottoNumber.size() == 3) {
            return Prize.FIFTH;
        }
        return Prize.SIXTH;
    }
}

