package lotto.domain;

public class LottoStore {

    private final LottoPicker lottoPicker;

    public LottoStore(LottoPicker lottoPicker) {
        this.lottoPicker = lottoPicker;
    }

    public PickedLottoNumbers buyLotto(LottoCount lottoCount) {
        PickedLottoNumbers pickedLottoNumbers = new PickedLottoNumbers();
        for (int count=0; count < lottoCount.getLottoCount(); count++) {
            pickedLottoNumbers.add(lottoPicker.pickLotto());
        }
        return pickedLottoNumbers;
    }
}
