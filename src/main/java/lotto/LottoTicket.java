package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoRule.getLottoNumbersSize;

public class LottoTicket {
    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        verifyDuplicate(lottoNumbers);
        verifySize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void verifySize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != getLottoNumbersSize()) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void verifyDuplicate(List<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> nonDuplicatedLottoNumbers = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != nonDuplicatedLottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복 될 수 없습니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .collect(Collectors.toList());
    }
}
