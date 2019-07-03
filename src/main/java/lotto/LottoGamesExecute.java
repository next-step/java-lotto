package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGamesExecute {

    private List<Lotto> lottos;

    public LottoGamesExecute() {
        lottos = new ArrayList <>();
    }

    public List<Lotto> extractLottoNumbers(int inputLottoGameCount) {
        for (int i = 0; i < inputLottoGameCount; i++) {
            lottos.add(new Lotto(LottoMachine.autoLottoNumber()));
        }
        return lottos;
    }

    public void manualLottoNumbers(List<String> lottoNumbers){
        for(String lottoNum : lottoNumbers){
            lottos.add(
                new Lotto(
                    Arrays.stream(lottoNum.split(","))
                          .map(Integer::parseInt)
                          .collect(Collectors.toList())
                )
            );
        }
    }

    public LottoGames lottoGameResult(String inputLastWeekLottoNumber, String inputLastWeekBonusNumber) {
        for (Lotto lotto : lottos) {
            lotto.winnerCheck(inputLastWeekLottoNumber, inputLastWeekBonusNumber);
        }
        LottoGames lottoGames = new LottoGames(lottos);
        return lottoGames;
    }

}
