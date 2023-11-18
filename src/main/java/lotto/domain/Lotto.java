package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.validate.NumberValidation.checkLottoSize;

public class Lotto {

    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkLottoSize(lottoNumbers);
        this.lottoNumbers = sortLotto(lottoNumbers);
    }

    public Lotto(Integer... numbers) {
        List<LottoNumber> lotto = Arrays.stream(numbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        checkLottoSize(lotto);
        this.lottoNumbers = sortLotto(lotto);
    }

    private List<LottoNumber> sortLotto(List<LottoNumber> lottoNumbers) {
        return Collections.unmodifiableList(lottoNumbers.stream()
                .sorted().collect(Collectors.toList()));
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

    public int match(Lotto lotto) {
        return lotto.lottoNumbers().stream()
                .filter(this.lottoNumbers::contains)
                .collect(Collectors.toList()).size();
    }

    public boolean matchNumber(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        return String.format("[%s]", lottoNumbers.stream().map(LottoNumber::toString)
                .collect(Collectors.joining(", ")));
    }
}
