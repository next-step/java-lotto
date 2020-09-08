package lotto.domain;

import lotto.common.LottoPriceInfo;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    private Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int matchNumbers(LottoTicket winningTicket) {
        HashSet<LottoNumber> matchNumbers = new HashSet<>(this.lottoNumbers);
        matchNumbers.retainAll(winningTicket.lottoNumbers);
        return matchNumbers.size();
    }

    public LottoPriceInfo matchNumbers2(LottoTicket winningTicket) {
        int matchCount = matchCount(winningTicket);
        return LottoPriceInfo.matchInfo(matchCount);
    }

    private int matchCount(LottoTicket winningTicket) {
        HashSet<LottoNumber> matchNumbers = new HashSet<>(this.lottoNumbers);
        matchNumbers.retainAll(winningTicket.lottoNumbers);
        return matchNumbers.size();
    }

    @Override
    public String toString() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(this.lottoNumbers);
        Collections.sort(lottoNumbers);

        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}