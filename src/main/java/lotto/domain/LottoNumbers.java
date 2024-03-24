package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final List<LottoNumber> LOTTO_NUMBERS = initialLottoRange();

    private static List<LottoNumber> initialLottoRange() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 46).boxed().map(LottoNumber::new).collect(Collectors.toList());

        return lottoNumbers;
    }

    public static List<LottoNumber> issueNumbers() {
        List<LottoNumber> issueNumbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(issueNumbers);
        issueNumbers = issueNumbers.subList(0, 6);
        Collections.sort(issueNumbers);
        return issueNumbers;
    }
}
