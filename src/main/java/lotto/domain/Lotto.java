package lotto.domain;

import lotto.request.ManualLottoRequest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validateLotto(List<Integer> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        validateDuplicatedLottoNumbers(lottoNumbers);
    }

    private void validateLottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
    }

    private void validateDuplicatedLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> numbers = new HashSet<>(lottoNumbers);
        if (numbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되면 안 됩니다.");
        }
    }

    public int countMatchNumber(Lotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean matchBonusNumber(LottoNumber bonusNumber) {
        return this.contains(bonusNumber);
    }

    private boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public static Lotto from(ManualLottoRequest manualLottoRequest) {
        return new Lotto(manualLottoRequest.getManualLottoRequest());
    }
}
