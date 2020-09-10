package domain;

public class LottoGames {

    private Lottos lottos;

    public LottoGames(int autoTries , Lottos manualCreated) {
        lottos = new Lottos();

        combineLottoManual(manualCreated);
        makeLottoAuto(autoTries);
    }

    private void combineLottoManual(Lottos manualTries) {
        if(manualTries.getNumOfLottos() > 0){
            lottos.getLottos().addAll(manualTries.getLottos());
        }
    }

    private void makeLottoAuto(int autoTries) {
        NumberGenerator generator = new NumberGenerator();

        for (int i = 0; i < autoTries; i++) {
            lottos.addLotto(new Lotto(generator.generate()));
        }
    }
    public Lottos getLottos() {
        return lottos;
    }
}
