package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT_LIMIT = 6;
    private List<Integer> lottoNumbers;

    public Lotto(Integer... input) {
        this(Arrays.asList(input));
    }

    public Lotto(String input) {
        this(Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() < LOTTO_NUMBER_COUNT_LIMIT) {
            throw new IllegalArgumentException("로또 숫자는 6개 입니다.");
        }
        Collections.sort(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int matchCount(WinningLotto winningLotto) {
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningLotto.getWinnerNumbers().contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

}
