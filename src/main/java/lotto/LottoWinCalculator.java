package lotto;

import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinCalculator {

    private final List<LottoNumbers> pickedLottoNumbers = new ArrayList<>();
    private LottoNumbers winLottoNumbers;

    /**
     * 발급 된 로또번호를 추가합니다
     * @param pickedLottoNumbers
     */
    public void addPickedLottoNumbers(List<Integer> pickedLottoNumbers) {
        this.pickedLottoNumbers.add(new LottoNumbers(pickedLottoNumbers));
    }

    /**
     * 당첨번호를 세팅합니다.
     * @param winLottoNumbers
     */
    public void setWinLottoNumbers(LottoNumbers winLottoNumbers) {
        this.winLottoNumbers = winLottoNumbers;
    }

    /**
     * 세팅 된 당첨번호와 발급 된 로또번호를 비교하여 각 일치하는 개수를 반환합니다.
     * @return
     */
    public List<Integer> calculateMatchedCounts() {
        return this.pickedLottoNumbers.stream()
                .map(lottoNumbers -> lottoNumbers.matchedLottoNumbersCount(this.winLottoNumbers))
                .collect(Collectors.toList());
    }

}
