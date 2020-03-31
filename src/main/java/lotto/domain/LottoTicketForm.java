package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoTicketForm {
    private final List<LottoNumber> lottoNumbers;

    private LottoTicketForm(List<LottoNumber> lottoNumbers) {
        verifySize(lottoNumbers);
        verifyDuplicate(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private static LottoTicketForm write(List<LottoNumber> lottoNumbers) {
        return new LottoTicketForm(lottoNumbers);
    }

    private void verifySize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LottoTicket.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void verifyDuplicate(List<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> nonDuplicatedLottoNumbers = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != nonDuplicatedLottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복 될 수 없습니다.");
        }
    }
}
