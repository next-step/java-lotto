package lotto.domain;

import exception.CustomException;
import lotto.exception.LottoErrorCode;
import lotto.view.LottoResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;

    private final LottoStorage lottoStorage;
    private final int lottoSize;
    private final int purchaseAmount;

    public LottoStore(int purchaseAmount, List<String> manualLottoList) {
        this.purchaseAmount = purchaseAmount;
        this.lottoSize = purchaseAmount / LOTTO_PRICE;

        validateAvailableForPurchase(lottoSize, manualLottoList.size());
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(createManualLotto(manualLottoList));
        lottoList.addAll(createAutoLotto(calculateAutoLottoSize(manualLottoList.size())));
        this.lottoStorage = new LottoStorage(lottoList);

        LottoResultView.printLottoCount(lottoSize-manualLottoList.size(),
                manualLottoList.size());
    }

    private void validateAvailableForPurchase(int lottoSize, int manualLottoSize) {
        if (lottoSize < manualLottoSize) {
            throw new CustomException(LottoErrorCode.LOTTO_MANUAL_NUMBER_OUT_OF_LANGE);
        }
    }

    private List<Lotto> createManualLotto(List<String> manualLottoList) {
        List<Lotto> result = new ArrayList<>();
        for (String manualLotto : manualLottoList) {
            result.add(StringLottoNumbers.toLotto(manualLotto));
        }
        return result;
    }

    private List<Lotto> createAutoLotto(int autoLottoSize) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < autoLottoSize; i++) {
            result.add(LottoNumberRange.createLotto());
        }
        return result;
    }

    private int calculateAutoLottoSize(int manualLottoSize) {
        return lottoSize - manualLottoSize;
    }

    public List<Lotto> getLotto() {
        return lottoStorage.copy();
    }

    public float calculateYield(Long winningAmountSum) {
        return (float) winningAmountSum / purchaseAmount;
    }
}
