package domain;

import constants.LottoConstant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateRedundancy(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoConstant.MAX_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 6개가 필요합니다.");
        }
    }

    private void validateRedundancy(List<Integer> lottoNumbers) {
        Set<Integer> noOverlappingNumbers = new HashSet<>(lottoNumbers);
        if (noOverlappingNumbers.size() != LottoConstant.MAX_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 모두 달라야 합니다.");
        }
    }

    @Override
    public String toString() {
        return "" + lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
