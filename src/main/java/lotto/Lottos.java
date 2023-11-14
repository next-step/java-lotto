package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoList;
    private LottoGenerator generator = new LottoGenerator();
    public Lottos() {}

    Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void generate(Integer inputNumber) {
        checkInputNumber(inputNumber);
        lottoList = new ArrayList<>(inputNumber);
        lottoList = generator.generateByInputNumber(inputNumber);
    }

    private void checkInputNumber(Integer inputNumber) {
        if (inputNumber == null || inputNumber <= 0) {
            throw new IllegalArgumentException("Input lotto number is null or 0");
        }
    }

    public int getNumberOfLotto() {
        return lottoList.size();
    }

    public WinningLottoManager countAllWinning(List<Integer> winningNumber) {
        WinningLottoManager winningManager = new WinningLottoManager(winningNumber);
        for (Lotto lotto : lottoList) {
            winningManager.countWinning(lotto);
        }
        return winningManager;
    }
}
