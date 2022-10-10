package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Gambler {
    private final List<LottoNumbers> gambleHistory = new ArrayList<>();

    private final LottoNumbersGenerator lottoNumbersGenerator;

    public Gambler(LottoNumbersGenerator lottoNumberGenerator) {
        this.lottoNumbersGenerator = lottoNumberGenerator;
    }

    public void playGambleWithTime(int playTimes) {
        for (int i = 0; i < playTimes; i++) {
            playGamble();
        }
    }

    private void playGamble() {
        gambleHistory.add(lottoNumbersGenerator.create());
    }

    public List<LottoNumbers> getGambleHistory() {
        return gambleHistory;
    }
}
