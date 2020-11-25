package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private long matchCnt;
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(long matchCnt, List<LottoNumber> lottoNumbers) {
        this.matchCnt = matchCnt;
        this.lottoNumbers.addAll(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public long getMatchCnt() {
        return matchCnt;
    }

    public void checkMatchingNumbers(List<String> winningNums) {
        List<LottoNumber> winningNumbers = winningNums.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        matchCnt = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
