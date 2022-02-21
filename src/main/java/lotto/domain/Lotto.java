package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<String> numberStrings) {
        this.lottoNumbers = new ArrayList<>(makeLottoNumbers(numberStrings));

        validateDuplicateNumber(lottoNumbers);
        validateSize(lottoNumbers);
    }

    public static List<LottoNumber> makeLottoNumbers(List<String> numberStrings) {
        return numberStrings.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public List<Integer> getLotto() {
        return lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());
    }

    public boolean matchBonusNumber(int count, LottoNumber bonusNumber) {
        boolean isBonusNumber = contains(bonusNumber.getNumber());
        if (count != LOTTO_NUMBERS_SIZE - 1) {
            isBonusNumber = false;
        }
        return isBonusNumber;
    }

    public boolean contains(final int number) {
        return getLotto()
            .contains(number);
    }

    public int match(final Lotto lotto) {
        return (int) lotto.getLotto().stream()
            .filter(this::contains)
            .count();
    }

    private static void validateDuplicateNumber(final List<LottoNumber> numbers) {
        final List<Integer> deleteDuplicateNumbers = numbers.stream()
            .map(LottoNumber::getNumber)
            .distinct()
            .collect(Collectors.toList());
        if (numbers.size() != deleteDuplicateNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
        }
    }

    private static void validateSize(final List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 번호는 " + LOTTO_NUMBERS_SIZE + "개여야 합니다.");
        }
    }
}
