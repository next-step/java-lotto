package lotto.domain;

import java.util.*;

public class LottoGame {
    public static final int GAME_AMOUNT = 1000;
    private static final int MIN_GAME_COUNT = 1;
    private static final String MONEY_LOW_MESSAGE = "금액이 부족합니다.";
    private static final String NO_INIT_WINNING_NUMBER = "당첨번호가 입력되지 않았습니다.";

    private List<Lotto> lottos;
    private Lotto winningLotto = null;

    public LottoGame(int money) {
        int gameCount = gameCount(money);
        if (gameCount < MIN_GAME_COUNT) {
            throw new IllegalArgumentException(MONEY_LOW_MESSAGE);
        }

        initLottos(gameCount);
    }

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private int gameCount(int money) {
        return money / GAME_AMOUNT;
    }

    private void initLottos(int gameCount) {
        lottos = new ArrayList<>();
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

    public LottoResult result() {
        if (!isInitWinningLotto()) {
            throw new RuntimeException(NO_INIT_WINNING_NUMBER);
        }

        LottoResult lottoResult = new LottoResult(gameMoney());
        for (Lotto lotto : lottos) {
            lottoResult.update(lotto.compare(winningLotto));
        }

        return lottoResult;
    }

    private int gameMoney() {
        return this.lottos.size() * GAME_AMOUNT;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
