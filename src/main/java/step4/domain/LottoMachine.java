package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final int FROM_INDEX = 0;
    private final int TO_INDEX = 6;

    private List<LottoNumber> lottoNumbers = new ArrayList<>(new LottoNumber().getLottoNumberCache().values());

    public LottoList buyLotto(LottoTicketCount lottoTicketCount, List<String> manualNumbersList) {
        LottoList lottoList = new LottoList();

        if (lottoTicketCount.getManualLottoCount() > 0) {
            buyManualLotto(manualNumbersList, lottoList);
        }

        buyAutoLotto(lottoTicketCount.getAutoLottoCount(), lottoList);

        return lottoList;
    }

    private void buyManualLotto(List<String> manualNumbersList, LottoList lottoList) {
        for (String manualNumbers : manualNumbersList) {
            lottoList.add(new Lotto(manualNumbers));
        }
    }

    private void buyAutoLotto(int autoTicketCount, LottoList lottoList) {
        for (int i = 0; i < autoTicketCount; i++) {
            lottoList.add(createLotto());
        }
    }

    private Lotto createLotto() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> extractionLottoNumbers = lottoNumbers.subList(FROM_INDEX, TO_INDEX);
        Collections.sort(extractionLottoNumbers);

        return new Lotto(extractionLottoNumbers);
    }
}
