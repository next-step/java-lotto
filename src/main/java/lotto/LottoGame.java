package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int gamePrice = 1000;
    private final int gameMoney;
    private final List<Lotto> lottoList;
    public LottoGame(int gameMoney){
        this.gameMoney = gameMoney;
        this.lottoList = generateLotto(gameMoney/gamePrice);
    }

    private List<Lotto> generateLotto(int count){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0;i<count;i++){
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }
}
