package lotto.data;

public class LottoBundle {
    private Lottos autoLottos;
    private Lottos manualLottos;

    public LottoBundle(Lottos manualLottos){
        this.manualLottos = manualLottos;
    }

    public static LottoBundle manualOf(Lottos manualLottos){
        return new LottoBundle(manualLottos);
    }

    public void addAuto(Lottos autoLottos) {
        this.autoLottos = autoLottos;
    }

    public Lottos manual() {
        return this.manualLottos;
    }

    public Lottos auto(){
        return this.autoLottos;
    }
}
