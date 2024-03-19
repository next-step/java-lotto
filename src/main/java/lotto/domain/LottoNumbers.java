package lotto.domain;

import lotto.data.LottoNumberVO;
import lotto.data.LottoWinInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.ConstUtils.*;

public class LottoNumbers {

    private final List<LottoNumberVO> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = getAutoLottoNumbers();
    }

    public LottoNumbers(List<Integer> manualNumbers) {
        this.lottoNumbers = new ArrayList<>();

        manualNumbers.forEach(number -> this.lottoNumbers.add(new LottoNumberVO(number)));
    }

    public List<LottoNumberVO> getPurchasedLottoNumber() {
        return List.copyOf(this.lottoNumbers);
    }

    public LottoWinInfo countMatchWithWinningLottoNumbers(LottoNumbers winningLottoNumbers) {
        int resultCount = (int) this.lottoNumbers.stream()
                .map(winningLottoNumbers::containNumbers)
                .filter(result -> result)
                .count();

        return LottoWinInfo.valueOf(resultCount);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    private List<LottoNumberVO> getAutoLottoNumbers() {
        List<Integer> lotto = new ArrayList<>();
        for (int i = MINIMUM_LOTTO_RANGE; i <= MAXIMUM_LOTTO_RANGE; i++) {
            lotto.add(i);
        }
        Collections.shuffle(lotto);
        lotto = lotto.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(lotto);

        List<LottoNumberVO> selectedLotto = new ArrayList<>();
        lotto.forEach(number -> selectedLotto.add(new LottoNumberVO(number)));

        return selectedLotto;
    }

    private boolean containNumbers(LottoNumberVO number) {
        return this.lottoNumbers.stream()
                .anyMatch(lotto -> lotto.equals(number));
    }
}
