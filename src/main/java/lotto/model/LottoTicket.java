package lotto.model;

import java.util.List;

public class LottoTicket {
    public static final double LOTTO_NUBERS_SIZE = 6;
    private List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUBERS_SIZE) {
            throw new IllegalArgumentException("로또 티켓의 로또 숫자는 6개이어야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
