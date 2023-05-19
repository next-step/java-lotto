package step2.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    private final List<LottoNo> lottoTicket;

    public LottoTicket(List<LottoNo> lottoNumbers) {
        validInputNumber(lottoNumbers);
        this.lottoTicket = new ArrayList<>(lottoNumbers);
    }

    public LottoTicket(Set<LottoNo> lottoNumbers) {
        validInputNumber(lottoNumbers);
        lottoTicket = new ArrayList<>(lottoNumbers);
    }

    private static void validInputNumber(Collection<LottoNo> lottoNos) {
        if (lottoNos.size() != LottoCommonValue.DEFAULT_LOTTO_NUMBER_COUNT.value()) {
            throw new IllegalArgumentException(lottoNos + " : 입력한 숫자를 확인해 주세요");
        }
    }

    public boolean isContain(LottoNo number) {
        return this.lottoTicket.contains(number);
    }

    public Rank checkLottoTicket(LottoTicket winningTicket, int bonusNumber) {
        int count = (int) lottoTicket.stream()
                .filter(i -> winningTicket.isContain(i))
                .count();

        return Rank.toPrizeMoney(count, isContain(LottoNo.of(bonusNumber)));
    }

    public String printTicket() {
        return lottoTicket.toString();
    }

}
