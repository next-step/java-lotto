package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto implements Comparable<Lotto>{

    List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) object;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private static int addResult(List<Integer> winner, Integer lottoNumber) {
        if (winner.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }


    @Override
    public int compareTo(Lotto winner) {
        int result = 0;
        for (Integer lottoNumber : lottoNumbers) {
            result += addResult(winner.getLottoNumbers(), lottoNumber);
        }
        return result;
    }
}
