package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
    }

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers newInstance() {
        return new LottoNumbers();
    }

    public static LottoNumbers newInstance(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("로또 번호 묶음이 존재하지 않습니다.");
        }

        if (lottoNumbers.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("로또 번호가 존재하지 않습니다.");
        }
    }

    public void addAll(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers.addAll(lottoNumbers);
    }

    public LottoNumbers clone() {
        return newInstance(toList());
    }

    public List<LottoNumber> toList() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    public int getCount() {
        return this.lottoNumbers.size();
    }

    public int getCountByCreationType(CreationType creationType) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.getCreationType().equals(creationType))
                .count();
    }

    public LottoMatchResult calculateMatchCount(LottoNumber lastWinLottoNumber, BonusNumber bonusNumber) {
        LottoMatchResult lottoMatchResult = LottoMatchResult.newInstance();

        this.lottoNumbers.forEach(lottoNumbers -> {
            LottoMatch lottoMatch = LottoMatch.findByCount(lottoNumbers.getMatchCount(lastWinLottoNumber),
                    lottoNumbers.isMatchNumber(bonusNumber.getBonusNumber()));
            lottoMatchResult.increaseMatchCount(lottoMatch);
        });

        return lottoMatchResult;
    }

}
