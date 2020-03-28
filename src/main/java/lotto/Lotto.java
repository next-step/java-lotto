package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_MAX_SOCKET = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        generatorLottoNumbers();
        sortLottorNumbers();
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validate();
        sortLottorNumbers();
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public boolean isExistNumber(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                .filter(l -> l.equals(lottoNumber))
                .collect(Collectors.toList()).size() > 0;
    }

    private void sortLottorNumbers() {
        this.lottoNumbers = this.lottoNumbers.stream()
                .sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .collect(Collectors.toList());
    }

    private void generatorLottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_MAX_SOCKET; i++) {
            LottoNumber lottoNumber = makeLottoNumber();
            this.lottoNumbers.add(lottoNumber);
        }
    }

    private LottoNumber makeLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber();
        while (isExistNumber(lottoNumber)) {
            lottoNumber = new LottoNumber();
        }
        return lottoNumber;
    }

    private void validate() {
        if (this.lottoNumbers.size() != LOTTO_MAX_SOCKET) {
            throw new IllegalArgumentException("로또는 6개 숫자로 이뤄져야 합니다.");
        }
    }
}
