package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTickets {

    private final List<LottoTicket> lottoNumbers;

    private LottoTickets() {
        this.lottoNumbers = new ArrayList<>();
    }

    private LottoTickets(List<LottoTicket> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTickets newInstance() {
        return new LottoTickets();
    }

    public static LottoTickets newInstance(List<LottoTicket> lottoNumbers) {
        return new LottoTickets(lottoNumbers);
    }

    private void validateLottoNumbers(List<LottoTicket> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("로또 번호 묶음이 존재하지 않습니다.");
        }

        if (lottoNumbers.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("로또 번호가 존재하지 않습니다.");
        }
    }

    public LottoTickets addAll(List<LottoTicket> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers.addAll(lottoNumbers);

        return clone();
    }

    public LottoTickets clone() {
        return newInstance(toList());
    }

    public List<LottoTicket> toList() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    public int getCount() {
        return this.lottoNumbers.size();
    }

    public int getCountByCreationType(CreationType creationType) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.equalsCreationType(creationType))
                .count();
    }

    public LottoMatchResult calculateMatchCount(LottoTicket lastWinLottoTicket, LottoNumber bonusNumber) {
        LottoMatchResult lottoMatchResult = LottoMatchResult.newInstance();

        this.lottoNumbers.forEach(lottoNumbers -> {
            LottoMatch lottoMatch = LottoMatch.findByCount(lottoNumbers.getMatchCount(lastWinLottoTicket),
                    lottoNumbers.isMatchNumber(bonusNumber));
            lottoMatchResult.increaseMatchCount(lottoMatch);
        });

        return lottoMatchResult;
    }

}
