package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicates(lottoNumbers);
        return new Lotto(convertLotto(lottoNumbers));
    }

    private static void validateSize(List<Integer> lottoNumbers) {
        if (!isValidSize(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호는 6자리여야합니다.");
        }
    }

    private static void validateDuplicates(List<Integer> lottoNumbers) {
        if (hasDuplicates(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호는 중복되면 안됩니다.");
        }
    }

    private static boolean isValidSize(List<Integer> lottoNumbers) {
        return lottoNumbers.size() == LOTTO_NUMBER_COUNT;
    }

    private static boolean hasDuplicates(List<Integer> lottoNumbers) {
        return Set.copyOf(lottoNumbers).size() != lottoNumbers.size();
    }

    private static List<LottoNumber> convertLotto(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public Prize determinePrize(Lotto winningLotto) {
        int matchingCount = (int) lottoNumbers.stream()
                .filter(winningLotto::contain)
                .count();
        return PrizeSelector.selectByCount(matchingCount);
    }

    private boolean contain(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
