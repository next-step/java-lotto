package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    public static final int COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        if (lottoLengthValidation(lottoNumbers)) {
            throw new IllegalArgumentException("6개의 로또가 필요합니다");
        }
        if (lottoDuplication(lottoNumbers)) {
            throw new RuntimeException("6개의 로또가 필요합니다");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public int compareLottoAndWinnerNumbers(final LottoMachine lottoMachine) {
        return Long.valueOf(lottoNumbers.stream()
            .filter(lottoMachine::isContain).count()).intValue();
    }

    public int compareLottoAndBonusNumbers(final LottoMachine lottoMachine) {
        return Long.valueOf(lottoNumbers.stream()
            .filter(lottoMachine::isEqualBonusNumber).count()).intValue();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    private boolean lottoLengthValidation(List<LottoNumber> line) {
        return line.size() != COUNT;
    }

    private boolean lottoDuplication(List<LottoNumber> lottoLine) {
        HashSet<LottoNumber> checkDuplicationValue = new HashSet<>(lottoLine);
        return checkDuplicationValue.size() != 6;
    }
}
