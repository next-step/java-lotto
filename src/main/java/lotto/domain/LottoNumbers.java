package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        checkValidSize(lottoNumbers);
        checkValidDuplication(lottoNumbers);

        List<LottoNumber> initLottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        this.lottoNumbers = getSortedNumbers(initLottoNumbers);
    }

    private List<LottoNumber> getSortedNumbers(List<LottoNumber> lottoNumbers) {
        List<LottoNumber> sortedNumbers = new ArrayList<>(lottoNumbers);
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
    }

    public int getCountOfMatchLottoNumber(LottoNumbers winningNumbers) {
        return (int) winningNumbers.getLottoNumbers().stream()
                .filter(this::containsLottoNumber)
                .count();
    }

    private boolean containsLottoNumber(LottoNumber winningNumber) {
        return this.lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.getLottoNumber() == winningNumber.getLottoNumber());
    }

    public boolean isMatchBonusNumber(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        return winningLottoNumbers.getLottoNumbers().contains(bonusNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private void checkValidDuplication(List<Integer> winningLottoNumbers) {
        int distinctList = winningLottoNumbers.stream().distinct().collect(Collectors.toList()).size();
        if (winningLottoNumbers.size() != distinctList) {
            throw new IllegalArgumentException("입력한 로또 숫자에 중복된 값이 있습니다.");
        }
    }

    private void checkValidSize(List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.size() != LOTTO_SIZE)
            throw new IllegalArgumentException("입력한 로또 사이즈가 6이여야 합니다!");
    }

}
