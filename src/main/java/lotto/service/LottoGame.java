package lotto.service;

import lotto.dto.Lotto;
import lotto.dto.Rank;
import lotto.dto.WinningLotto;
import lotto.utils.LottoMaker;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final int FEE_OF_ONE_TRY = 1_000;


    private int money;
    private List<Lotto> gamePlays;
    private int autoGames;
    private int manualGames;


    public LottoGame(int money, int manual) {
        this.money = money;
        autoGames = getNumOfGames(money) - manual ;
        manualGames = manual;
        gamePlays= new ArrayList<>();
        gameSettingAutoGames();
        gameSettingManualGames();
    }

    public int getMoney() {
        return money;
    }

    public static int getNumOfGames(int money){
        return money/FEE_OF_ONE_TRY;
    }

    public void gameSettingAutoGames() {
        for (int i = 0 ; i < autoGames ; i++){
            gamePlays.add(LottoMaker.lottoOf());
        }
        System.out.println(gamePlays.size() );
    }

    public void gameSettingManualGames(){
            gamePlays.addAll(LottoMaker.ofNewLine(InputView.manualgame(manualGames)));
            System.out.println(gamePlays.size() );
    }

    public List<Lotto> getGamePlays() {
        return gamePlays;
    }

    public Map<Rank, Integer> match(WinningLotto winnersNum){
        return winnersNum.match(gamePlays);
    }

    public int getAutoGames() {
        return autoGames;
    }

    public int getManualGames() {
        return manualGames;
    }
}
