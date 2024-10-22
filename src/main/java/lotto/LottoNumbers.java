package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> LOTTO_CANDIDATE_NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = generateAutoLottoNumbers();
        this.validateLottoNumbers();
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
        this.validateLottoNumbers();
    }

    private boolean validateLottoNumbers() {
        if (lottoNumbers.size() != new HashSet<>(lottoNumbers).size()) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("번호 갯수가 6개가 아닙니다.");
        }
        return true;
    }

    public List<LottoNumber> getValues() {
        return lottoNumbers;
    }

    public String toStringLottoNumbers() {
        Collections.sort(lottoNumbers);
        return lottoNumbers.stream().map(d -> String.valueOf(d.getValue())).collect(Collectors.joining(", "));
    }

    public List<LottoNumber> generateAutoLottoNumbers() {
        Collections.shuffle(LOTTO_CANDIDATE_NUMBERS);
        return LOTTO_CANDIDATE_NUMBERS.stream().limit(LOTTO_NUMBER_COUNT).map(LottoNumber::new).collect(Collectors.toList());
    }

    public boolean hasLottoNumber(LottoNumber lottoNumber){ //todo LottoNumber ? int ?
        return this.lottoNumbers.contains(lottoNumber);
    }
}
