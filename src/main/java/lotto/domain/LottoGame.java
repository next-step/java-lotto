package lotto.domain;

import java.util.*;

public class LottoGame {
    public static final int GAME_AMOUNT = 1000;
    private static final int MIN_GAME_COUNT = 1;
    private static final String MONEY_LOW_MESSAGE = "금액이 부족합니다.";
    private static final String NO_INIT_WINNING_NUMBER = "당첨번호가 입력되지 않았습니다.";

    private UserLotto userLotto;
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public LottoGame(int money) {
        int gameCount = gameCount(money);
        if (gameCount < MIN_GAME_COUNT) {
            throw new IllegalArgumentException(MONEY_LOW_MESSAGE);
        }

        userLotto = UserLotto.generatedAuto(gameCount);
    }

    public LottoGame(List<Lotto> lottos) {
        userLotto = UserLotto.of(lottos);
    }

    private int gameCount(int money) {
        return money / GAME_AMOUNT;
    }

    public int lottoSize() {
        return userLotto.size();
    }

    public void winningLotto(String winningLottoString, int bonus) {
        List<LottoNumber> lottoNumbers = LottoBox.parseNumberString(winningLottoString);
        this.winningLotto = new Lotto(lottoNumbers);
        bonusNumber = new LottoNumber(bonus);
    }

    public boolean isInitWinningLotto() {
        return Objects.nonNull(this.winningLotto);
    }

    public LottoResult result() {
        if (!isInitWinningLotto()) {
            throw new RuntimeException(NO_INIT_WINNING_NUMBER);
        }

        return userLotto.result(winningLotto, bonusNumber, gameMoney());
    }

    private int gameMoney() {
        return userLotto.size() * GAME_AMOUNT;
    }

    public List<Lotto> getLottos() {
        return userLotto.unmodifiableLottos();
    }
}
