package step3.model;

import java.util.Set;
import java.util.TreeSet;

public final class LottoNumbers {

    private static final int MAX_SIZE = 7;
    private static final String CHECK_SIZE = "6개의 숫자까지만 담을 수 있습니다.";

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = new TreeSet<>();
    }

    public void addNumber(LottoNumber lottoNumber) {

        if (!isAddAvailable()) {
            throw new IllegalArgumentException(CHECK_SIZE);
        }

        lottoNumbers.add(lottoNumber);
    }

    private boolean isAddAvailable() {
        return lottoNumbers.size() < MAX_SIZE;
    }

}
