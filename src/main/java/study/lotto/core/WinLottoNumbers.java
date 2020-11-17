package study.lotto.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 당첨 번호
 */
public class WinLottoNumbers {

    private List<LottoNumber> winLottoNumbers = new ArrayList<>();

    public WinLottoNumbers(List<LottoNumber> winLottoNumbers) {
        this.winLottoNumbers = winLottoNumbers;
    }

    public List<LottoNumber> match(Lotto lotto) {
        List<LottoNumber> matchingLottoNumbers = new ArrayList<>();
        // 일치하는 번호 추가
        this.winLottoNumbers.stream()
                .filter(lotto::contains)
                .forEach(matchingLottoNumbers::add);

        return matchingLottoNumbers;
    }

}
