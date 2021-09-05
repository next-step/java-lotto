package lotto;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int amount = InputView.getPurchaseAmount();

        ResultView.printCount(lottoGenerator.getCount(amount));
        List<Lotto> lottoList = lottoGenerator.generateLotto(amount);
        ResultView.printLottoList(lottoList);

        InputView.refreshLine();

        String numbers = InputView.getWinningNumbers();
        LottoNumbers winningNumbers = new LottoNumbers(StringParser.parse(numbers));

        LottoResult lottoResult = new LottoResult(amount);
        for (Lotto lotto : lottoList) {
            LottoRank rank = lotto.checkWinning(winningNumbers);
            lottoResult.record(rank);
        }

        ResultView.printResult(lottoResult);
    }
}
