package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottoResult {
    private List<LottoNumber> lottoResult;

    public LottoResult() {
        this.lottoResult = new ArrayList<>();
    }

    public LottoResult(List<LottoNumber> lottoNumbers) {
        this.lottoResult = lottoNumbers;
    }

    public static LottoResult fromIntegers(Set<Integer> lottoIntegers) {
        LottoResult lottoResult = new LottoResult();
        Iterator<Integer> iterator = lottoIntegers.iterator();
        while (iterator.hasNext()) {
            lottoResult.lottoResult.add(LottoNumber.from(iterator.next()));
        }
        return lottoResult;
    }

    public int size() {
        return lottoResult.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoResult;
    }

    public List<Integer> getLottoResult() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoResult) {
            int num = lottoNumber.getLottoNumber();
            lottoNumbers.add(num);
        }
        return lottoNumbers;
    }

    public int calculateCount(WinningNumbers winningNumbers) {
        int count = 0;
        return lottoResult.stream().mapToInt(num -> num.addCountIfContain(count, winningNumbers)).sum();
    }

    public boolean isBonusMatch(BonusNumber bonusNumber) {
        return lottoResult.stream()
                   .anyMatch(lottoNumber -> bonusNumber.isBonusMatch(lottoNumber));
    }
}
