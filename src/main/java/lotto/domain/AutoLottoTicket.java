package lotto.domain;

import java.util.Collections;
import java.util.List;

public class AutoLottoTicket extends LottoTicket {
    private static final int START_INDEX = 0;

    public AutoLottoTicket() {
        super(Collections.emptyList());
    }

    @Override
    protected List<LottoNumber> create(List<LottoNumber> lottoNumbers) {
        List<LottoNumber> lottoNumberCollections = LottoNumber.getLottoNumberCollection();
        Collections.shuffle(lottoNumberCollections);
        return lottoNumberCollections.subList(START_INDEX, NUMBER_OF_LOTTO_NUMBERS);
    }

}
