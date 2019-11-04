package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoGame {
    private static final int GAME_AMOUNT = 1000;
    private static final int MIN_GAME_COUNT = 1;
    private static final String MONEY_LOW_MESSAGE = "금액이 부족합니다.";

    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto = null;

    public LottoGame(int money) {
        int gameCount = gameCount(money);
        if (gameCount < MIN_GAME_COUNT) {
            throw new IllegalArgumentException(MONEY_LOW_MESSAGE);
        }

        initLottos(gameCount);
    }

    private int gameCount(int money) {
        return money / GAME_AMOUNT;
    }

    private void initLottos(int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            lottos.add(new Lotto(LottoBox.generateNumbers()));
        }
    }

    public int lottoSize() {
        return lottos.size();
    }

    public void winningLotto(String winningLottoString) {
        List<LottoNumber> lottoNumbers = LottoBox.parseNumberString(winningLottoString);
        this.winningLotto = new Lotto(lottoNumbers);
    }

    public boolean isInitWinningLotto() {
        return Objects.nonNull(this.winningLotto);
    }
}
