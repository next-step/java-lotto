package study.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(List<LottoNumber> collect) {
        lottoNumbers = collect;
        Collections.sort(lottoNumbers);
    }

    public Lotto(String[] numbers) {
        for(String number : numbers) {
            lottoNumbers.add(LottoNumber.of(Integer.parseInt(number.trim())));
        }
        Collections.sort(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int match(List<LottoNumber> winInput) {
        int matchCount = lottoNumbers.stream()
            .mapToInt(number -> winInput.contains(number) ? 1 : 0).sum();
        return matchCount;
    }
}
