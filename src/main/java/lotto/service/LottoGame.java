package lotto.service;

import lotto.dto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int FEE_OF_ONE_TRY = 1000;

    private int games;
    private int money;
    private List<Lotto> gamePlays;

    public LottoGame(int money){
        this.money = money;
        games = getNumOfGames(money);
        gamePlays = new ArrayList<>();
        gameSettingAllFrame();
    }

    public static int getNumOfGames(int money){
        return money/FEE_OF_ONE_TRY;
    }

    public void gameSettingAllFrame() {
        for (int i = 0 ; i < games ; i++){
            gamePlays.add(new Lotto());
        }
    }

    public List<Lotto> getGamePlays() {
        return gamePlays;
    }

    public int getMoney() {
        return money;
    }
}
