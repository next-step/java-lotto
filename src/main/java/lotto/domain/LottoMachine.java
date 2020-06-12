package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRIZE = 1000;
    private int money;
    private int manualCount;
    private int autoCount;
    private List<Lotto> lottoList;

    public LottoMachine(int money, int manualCount) {
        this.money = money;
        this.manualCount = manualCount;
        lottoList = new ArrayList<>();
    }

    private void validateCount(int totalLottoCount, int autoCount) {
        if (totalLottoCount == 0) {
            throw new IllegalArgumentException("Insufficient money");
        }

        if (autoCount < 0) {
            throw new IllegalArgumentException("Manual Count Cannot bigger than Total Lotto Count");
        }
    }

    public List<Lotto> generateLotto() {
        int totalLottoCount = this.money / LOTTO_PRIZE;
        autoCount = totalLottoCount - manualCount;
        validateCount(totalLottoCount, autoCount);

        lottoList.addAll(generateAutoLotto(autoCount));
        lottoList.addAll(generateManualLotto(manualCount));

        return lottoList;
    }

    public List<Lotto> generateLottoWithList(List<Lotto> lottoList) {
        return lottoList;
    }

    private List<Lotto> generateAutoLotto(int autoCount) {
        List<Lotto> autoLottoList = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            autoLottoList.add(new Lotto(new RandomLottoNumbers().generateNumbers()));
        }
        return autoLottoList;
    }

    private List<Lotto> generateManualLotto(int manualCount) {
        List<Lotto> manualLottoList = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualLottoList.add(new Lotto(new ManualLottoNumbers().generateNumbers()));
        }
        return manualLottoList;
    }

    public int getAutoLottoCount() {
        return autoCount;
    }

    public int getManualLottoCount() {
        return manualCount;
    }
}
