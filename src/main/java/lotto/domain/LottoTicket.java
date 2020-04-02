package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class LottoTicket {
    static final int LOTTO_NUMBERS_SIZE = 6;
    static final long PRICE = 1000;

    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        verifyDuplicate(lottoNumbers);
        verifySize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void verifySize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
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

    LottoTicketResult checkWinning(LottoTicket winningTicket, LottoNumber bonusNumber) {
        verifyBonusNumber(bonusNumber, winningTicket);
        int matchCount = (int) lottoNumbers.stream()
                .filter(winningTicket::contains)
                .count();
        boolean bonusMatch = lottoNumbers.contains(bonusNumber);
        return new LottoTicketResult(matchCount, bonusMatch);
    }

    private void verifyBonusNumber(LottoNumber bonusNumber, LottoTicket winningTicket) {
        if (winningTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.format("보너스 숫자(%d)는 중복될 수 없습니다.", bonusNumber.getNumber()));
        }
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
