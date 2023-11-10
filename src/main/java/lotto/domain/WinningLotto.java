package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> lottoNumbers;

    public WinningLotto(List<Integer> numbers) {
        this.lottoNumbers = new ArrayList<>();
        for(int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
    }

    public LottoRank winningRank(Lotto lotto) {
        int count = 0;
        for(LottoNumber lottoNumber : lottoNumbers) {
            if(lotto.contains(lottoNumber)) count++;
        }

        return LottoRank.searchBy(count);
    }
}
