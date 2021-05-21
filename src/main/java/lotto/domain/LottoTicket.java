package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    protected static final int NORMAL_COUNT_LOTTO_NUMBER = 6;

    private List<LottoNumber> lottoNumbers;

    protected LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket create(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NORMAL_COUNT_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호의 갯수는 6개여야합니다.");
        }
        return new LottoTicket(lottoNumbers);
    }

    public List<LottoNumber> numbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
