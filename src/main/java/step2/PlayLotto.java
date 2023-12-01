package step2;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {

    private final List<Lotto> lottos;
    private final Winnings winnings;

    public PlayLotto(int rounds) {
        this.lottos = new ArrayList<>();
        this.winnings = new Winnings();
        for (int i = 0; i < rounds; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public void printLottos(){
        ResultView resultView = new ResultView();
        for (Lotto lotto : lottos) {
            resultView.printLotto(lotto.toString());
        }
    }

    public int playLottos(Lotto winningNumber){
        for (Lotto lotto : lottos) {
            Prize prize = lotto.matchWinningNumber(winningNumber);
            winnings.addLottoValue(prize);
        }
        return winnings.getTotal();
    }

    public void printWinnings(){
        winnings.printWinnings();
    }

    public int getLottoSize(){
        return lottos.size();
    }

}
