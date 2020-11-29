package lotto_auto.model;

import java.util.List;
import java.util.stream.Collectors;


public class LottoTicket {

    public static final int PRICE = 1000;
    private final LottoNumbers lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = LottoNumbers.generate();
    }

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(
                lottoNumbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList())
        );
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    public DrawResult draw(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        boolean bonus = this.lottoNumbers.contains(bonusNumber);
        int matchNumberCount = this.lottoNumbers.computeMatchCount(winningLottoNumbers);
        return DrawResult.valueOf(bonus, matchNumberCount);
    }
}
