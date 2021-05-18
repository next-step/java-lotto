package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

public class LottoWon {
    private final Set<LottoNumber> lottoNumbers;

    public LottoWon(List<LottoNumber> convertStringToLottoNumberList) {
        this.lottoNumbers = new HashSet<>(convertStringToLottoNumberList);

        if (lottoNumbers.size() != LottoTicket.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(format("로또승리는 %d개의 번호를 가져야 합니다.", LottoTicket.LOTTO_NUMBERS_SIZE));
        }
    }
}
