package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.exception.LottoNumberException;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Lotto {
    public static final int LOTTO_NUMBER_START = 1;
    public static final int LOTTO_NUMBER_END = 45;

    private final List<LottoNo> lottoNumbers;

    public Lotto(List<LottoNo> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicates(lottoNumbers);

        this.lottoNumbers = lottoNumbers.stream()
            .sorted()
            .collect(toUnmodifiableList());
    }

    public static Lotto from(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers.stream()
            .map(LottoNo::new)
            .collect(toUnmodifiableList()));
    }

    private void validateSize(List<LottoNo> numbers) {
        if (numbers.size() != 6) {
            throw new LottoNumberException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicates(List<LottoNo> numbers) {
        Set<LottoNo> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new LottoNumberException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public boolean containsNumber(LottoNo number) {
        return lottoNumbers.contains(number);
    }

    public List<LottoNo> getLottoNumbers() {
        return lottoNumbers;
    }
}
