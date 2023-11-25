package domain.lotto;

import domain.lotto.domain.LottoGame;
import domain.lotto.domain.LottoLine;
import domain.lotto.domain.LottoNumber;
import domain.lotto.domain.WinnginLottoLine;
import domain.lotto.view.InputView;
import domain.lotto.view.OutputView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoApplication {
    public static void main(String[] args) {
        int buyingPrice = InputView.getBuyingPrice();
        int manualLottoCount = InputView.getManualLottoCount();
        List<String> manualLottoNumbers = InputView.getManualLottoNumber(manualLottoCount);

        List<LottoLine> manualLottoLines = manualLottoNumbers.stream()
                .map(LottoUtils::parseLottoNumbers)
                .map(LottoLine::new)
                .collect(Collectors.toList());

        LottoGame lottoGame = LottoGame.newInstance(buyingPrice, manualLottoCount, manualLottoLines);

        OutputView.printBuyingCount(lottoGame.getLottoLines().size(), manualLottoCount);
        OutputView.printLottoLines(lottoGame);

        String winningNumberAnswer = InputView.getWinningNumber();
        Set<LottoNumber> winningNumbers = LottoUtils.parseLottoNumbers(winningNumberAnswer);
        lottoGame.registerWinningLottoLine(new WinnginLottoLine(winningNumbers));
        lottoGame.registerBonusBall(InputView.getBonusBall());

        lottoGame.calculateStatistics();

        OutputView.printStatistics(lottoGame);

    }
}
