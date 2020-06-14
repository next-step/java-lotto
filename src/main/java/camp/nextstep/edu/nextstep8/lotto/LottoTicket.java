package camp.nextstep.edu.nextstep8.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private static final int LOTTO_PRICE = 1000;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(int amount) {
        validateBuyLotto(amount);
        lottoNumbers = new ArrayList<>();

        int lottoCount = amount / 1000;
        for(int i = 0; i < lottoCount; i++) {
            this.lottoNumbers.add(new LottoNumber());
        }
    }

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private void validateBuyLotto(int amount) {
        if(amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구매 금액은 최소 1000원 입니다");
        }
    }
}
