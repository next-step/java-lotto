package lotto.domain;

public class LottoStore {

    private final LottoPicker lottoPicker;
    private final LottoCount lottoCount;

    public LottoStore(LottoPicker lottoPicker, LottoCount lottoCount) {
        this.lottoPicker = lottoPicker;
        this.lottoCount = lottoCount;
    }

    public PickedLottoNumbers buyLotto() {
        PickedLottoNumbers pickedLottoNumbers = new PickedLottoNumbers();
        for (int count=0; count < lottoCount.getLottoCount(); count++) {
            LottoNumber lottoNumber = lottoPicker.pickLotto();
            pickedLottoNumbers.save(lottoNumber);
        }
        return pickedLottoNumbers;
    }
}
