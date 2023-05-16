package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    public static final int LOTTO_NUMBER_COUNT_LIMIT = 6;
    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateCount(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int matchLottoNumberCount(List<LottoNumber> numbers) {
        return (int) lottoNumbers.stream()
                .filter(number -> number.hasMatchNumbers(numbers))
                .count();
    }

    public Rank getRanking(List<LottoNumber> numbers) {
        return Rank.of(matchLottoNumberCount(numbers));
    }

    private void validateCount(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT_LIMIT) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> numberSet = new HashSet<>(lottoNumbers);
        if (numberSet.size() < LOTTO_NUMBER_COUNT_LIMIT) {
            throw new IllegalArgumentException("로또번호는 중복될 수 없습니다.");
        }
    }
}
