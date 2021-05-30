package lotto;

public class LottoBuy {
    private Lottos lottos;

    public LottoBuy() {
        lottos = new Lottos();
    }

    public void buyManualLotto(String manualLottoNumber) {
        lottos.createLotto(new Lotto(LottoValidationUtils.lottoNumberToListNumbers(manualLottoNumber)));
    }

    public Lottos buyAutoLotto(int autoLottoCount) {
        for (int count = 0; count < autoLottoCount; count++) {
            lottos.createLotto(new Lotto());
        }
        return lottos;
    }

    public Lottos buyOneRandomLotto(LottoRandomNumber lottoRandomNumber) {
        return new Lottos(new Lotto(lottoRandomNumber));
    }
}
