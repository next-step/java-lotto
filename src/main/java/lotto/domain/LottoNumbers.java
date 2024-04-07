package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 46;
    private static final int LOTTO_SIZE = 6;
    private static final List<LottoNumber> LOTTO_NUMBERS = initialLottoRange();

    private static List<LottoNumber> initialLottoRange() {
        List<LottoNumber> lottoNumbers = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed().map(LottoNumber::new).collect(Collectors.toList());
        return lottoNumbers;
    }

    public static Set<LottoNumber> issueNumbers() {
        List<LottoNumber> issueNumbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(issueNumbers);
        issueNumbers = issueNumbers.subList(0, LOTTO_SIZE);
        Collections.sort(issueNumbers);
        return new HashSet<>(issueNumbers);
    }
}
