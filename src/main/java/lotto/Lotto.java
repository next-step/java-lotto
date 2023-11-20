package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto implements Iterable<LottoNumber> {
    private final static int NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = LottoFactory.createLottoNumbers();
    }

    public Lotto(String inputNumbers) {
        List<LottoNumber> lottoNumbers = from(inputNumbers);
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private List<LottoNumber> from(String inputNumbers) {
        if (inputNumbers == null || inputNumbers.isBlank()) {
            return new ArrayList<>();
        }

        String[] arrayNumbers = inputNumbers.split(",");
        return Arrays.stream(arrayNumbers)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public void validate(List<LottoNumber> lottoNumbers) {
        checkLottoSizeIsValid(lottoNumbers);

        for (LottoNumber lottoNumber : lottoNumbers) {
            lottoNumber.validate(lottoNumber.lottoNumber());
        }
    }

    private void checkLottoSizeIsValid(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumberSet.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않은 6자리 숫자여야 합니다");
        }
    }

    public List<LottoNumber> lottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return this.lottoNumbers.iterator();
    }
}
