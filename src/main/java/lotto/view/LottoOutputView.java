package lotto.view;

import lotto.domain.LottoGames;

import static java.lang.String.format;

public class LottoOutputView {
    private static final String MESSAGE_LOTTO_GAMES_SIZE_= "%d개를 구매했습니다.";

    public void printLottoGamesSize(LottoGames lottoGames) {
        System.out.println(format(MESSAGE_LOTTO_GAMES_SIZE_, lottoGames.size()));
    }
}
