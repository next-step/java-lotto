package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;

    public LottoGame(int lottoCount) {
        LottoGenerator generator = new LottoGenerator();
        this.lottos = new ArrayList<>();

        int i=0;
        while (i < lottoCount) {
            Lotto lotto = Lotto.generateLotto(generator.generateRandomNumber());
            lottos.add(lotto);
            i ++;
        }
    }

    public LottoResult playingLotto(String inputWinningNumbers, Price price) {
        int[] intWinningNumbers = convertingWinningNumbers(inputWinningNumbers);
        LottoResult lottoGameResult =  new LottoResult(lottos, intWinningNumbers);
        lottoGameResult.calculateBenefit(price);
        return lottoGameResult;
    }

    public int[] convertingWinningNumbers(String winningNumbers) {
        String[] stringWinningNumbers = winningNumbers.replace(" ","").split(",");
        return Arrays.stream(stringWinningNumbers).mapToInt(str-> Integer.parseInt(str)).toArray();
    }

    public List<Lotto> lottos() {
        return lottos;
    }
}
