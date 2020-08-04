package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningNumber;
import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public LottoWinningResult match(LottoWinningNumber lottoWinningNumber) {
        return this.lottoNumbers
                .stream()
                .map(lottoNumber -> lottoWinningNumber.getMatchResult(lottoNumber))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        LottoWinningResult::new));
    }
}
