package lotto.lotto;

import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;
import lotto.prize.LottoPrize;
import lotto.prize.MatchInfo;

import java.util.List;
import java.util.Objects;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    private LottoTicket(LottoNumbers lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(LottoNumbers lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException("To init LottoTicket LottoNumbers can't be null");
        }
    }

    public static LottoTicket from(LottoNumbers lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public LottoPrize matchPrize(WinningNumbers winningNumbers) {
        MatchInfo matchInfo = winningNumbers.match(lottoNumbers);

        return LottoPrize.evaluate(matchInfo);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.toInts();
    }
}
