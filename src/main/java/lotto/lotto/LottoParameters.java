package lotto.lotto;

public class LottoParameters {
    private String[] manualLottos;
    private int autoCount;

    public LottoParameters(String[] manualLottos) {
        this(manualLottos, 0);
    }

    public LottoParameters(int autoCount) {
        this(null, autoCount);
    }

    public LottoParameters(String[] manualLottos, int autoCount) {
        this.manualLottos = manualLottos;
        this.autoCount = autoCount;
    }

    public String[] getManualLottos() {
        return manualLottos;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
