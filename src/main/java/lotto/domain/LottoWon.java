package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

public class LottoWon {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoWon(List<LottoNumber> convertStringToLottoNumberList) {
        this.lottoNumbers = new HashSet<>(convertStringToLottoNumberList);

        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(format("로또티켓은 %d개의 번호를 가져야 합니다.", LOTTO_NUMBERS_SIZE));
        }
    }
}
