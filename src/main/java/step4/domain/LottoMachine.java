package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LottoMachine {
    private final int PRICE = 1000;
    private final int FROM_INDEX = 0;
    private final int TO_INDEX = 6;

    private List<LottoNumber> lottoNumbers = new ArrayList<>(new LottoNumber().getLottoNumberCache().values());

    public LottoList buyLotto(int purchasePrice, List<String> manualNumbersList) {
        LottoList lottoList = new LottoList();

        int manualNumbersListSize = Optional.ofNullable(manualNumbersList)
                .map(List::size)
                .orElse(0);

        if (manualNumbersListSize > 0) {
            buyManualLotto(manualNumbersList, lottoList);
            purchasePrice = buyManualLottoChange(purchasePrice, manualNumbersList);
        }

        buyAutoLotto(purchasePrice, lottoList);

        return lottoList;
    }

    private void buyManualLotto(List<String> manualNumbersList, LottoList lottoList) {
        for (String manualNumbers : manualNumbersList) {
            lottoList.add(new Lotto(manualNumbers, LottoType.MANUAL));
        }
    }

    private int buyManualLottoChange(int purchasePrice, List<String> manualNumbersList) {
        return purchasePrice - (manualNumbersList.size() * this.PRICE);
    }

    private void buyAutoLotto(int purchasePrice, LottoList lottoList) {
        int buyCount = purchasePrice / this.PRICE;
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(createLotto());
        }
    }

    private Lotto createLotto() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> extractionLottoNumbers = lottoNumbers.subList(FROM_INDEX, TO_INDEX);

        Collections.sort(extractionLottoNumbers);

        return new Lotto(extractionLottoNumbers, LottoType.AUTO);
    }
}
