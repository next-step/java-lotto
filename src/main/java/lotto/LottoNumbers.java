package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> LOTTO_CANDIDATE_NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    private List<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = generateAutoLottoNumbers();
        validateLottoNumbers(this.getLottoNumbers());
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validateLottoNumbers(this.getLottoNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public String toStringLottoNumbers() {
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }

    public List<Integer> generateAutoLottoNumbers() {
        Collections.shuffle(LOTTO_CANDIDATE_NUMBERS);
        return LOTTO_CANDIDATE_NUMBERS.stream().limit(LOTTO_NUMBER_COUNT).collect(Collectors.toList());
    }

    public boolean validateLottoNumbers(List<Integer> lottoNumbers) { //todo private
        if (lottoNumbers.size() != new HashSet<>(lottoNumbers).size()) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("번호 갯수가 6개가 아닙니다.");
        }
        for (Integer number : lottoNumbers) {
            validateLottoNumber(number);
        }
        return true;
    }

    private boolean validateLottoNumber(int lottoNumber) {
        if (lottoNumber <= 0 || lottoNumber > 45) {
            throw new IllegalArgumentException("유효한 번호가 아닙니다.");
        }
        return true;
    }
}
