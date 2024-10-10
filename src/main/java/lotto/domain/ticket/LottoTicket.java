package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.result.Rank;

import java.util.List;

public class LottoTicket {

    public static final int SIZE_OF_LOTTO = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (isInvalidSizeOfLotto(lottoNumbers)) {
            throw new IllegalArgumentException("생성된 숫자 갯수 오류입니다.");
        }
    }

    private boolean isInvalidSizeOfLotto(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != SIZE_OF_LOTTO;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (LottoNumber lottoNumber : lottoNumbers) {
            builder.append(lottoNumber.toString()).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }

    public boolean match(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Rank match(WinningLotto winningLotto) {
        long matchCount = lottoNumbers.stream()
                .filter(winningLotto::winningMatch)
                .count();
        return Rank.of(matchCount);
    }
}
