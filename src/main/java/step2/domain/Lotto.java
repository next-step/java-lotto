package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto { // 로또 1장

    private final ArrayList<LottoNumber> lottoNumberNumbers;

    public Lotto(List<Integer> input) {

        this.lottoNumberNumbers = new ArrayList<>();

        // HashSet 사용 하여 숫자 중복 체크 하기

        for (Integer integer : input) {
            lottoNumberNumbers.add(new LottoNumber(integer));
        }
        // stream
    }

    public ArrayList<LottoNumber> getLottoNumbers() {
        return this.lottoNumberNumbers;
    }

    public int compareLottoNumbers(List<LottoNumber> winnerLotto) {

        int matchCount = 0;

        for(int i = 0; i < 6; i++) {
            if (this.lottoNumberNumbers.contains(winnerLotto.get(i))) {
                matchCount++;
            }
        }
        return matchCount;
    }

}
