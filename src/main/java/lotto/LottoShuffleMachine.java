package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShuffleMachine {

    private static final List<LottoNumber> lottoNumbers;

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    static {
        lottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
              .mapToObj(LottoNumber::new)
              .collect(Collectors.toList());
    }

    // 유틸리티 성격을 가진 클래스이므로 묵시적인 생성자를 방지한다.
    private LottoShuffleMachine() {
    }

    public static Set<LottoNumber> getSixNumbers() {
        Collections.shuffle(lottoNumbers);
        return new HashSet<>(lottoNumbers.subList(0, 6));
    }
}
