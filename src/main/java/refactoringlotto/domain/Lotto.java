package refactoringlotto.domain;

import refactoringlotto.random.LottoGenerator;

import java.util.List;

public class Lotto {
    private AllRoundLottoNumbers allRoundLottoNumbers;
    private LottoNumbers winningLottoNumbers;

    public Lotto(LottoGenerator lottoGenerator, int lottoTryCount) {
        allRoundLottoNumbers = AllRoundLottoNumbers.initAllRoundLottoNumbers(lottoGenerator,lottoTryCount);
    }
    public List<List<Integer>> totalRoundLottoNumberList(){
        return allRoundLottoNumbers.totalRoundLottoNumberList();
    }

    public void initWinningLottoNumbers(List<Integer> winningLottoNumbers){
        this.winningLottoNumbers = new LottoNumbers(winningLottoNumbers);
    }

    public List<Integer> lottoRankList(){
        return allRoundLottoNumbers.lottoRankList(winningLottoNumbers);

    }

}
