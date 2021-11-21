package lotto.controller;

import lotto.controller.view.InputView;
import lotto.controller.view.OutputView;
import lotto.domain.*;
import lotto.utils.IntegerParser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private LottoController() {
    }

    public static void main(String[] args) {
        try {
            lottoStart();
        } catch (IllegalArgumentException e) {
            System.out.println("\n잘못된 입력입니다: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n잠시 후 이용해주세요.");
        }
    }

    private static void lottoStart() {
        LottoTicket lottoTicket = publishLottoTicket();
        OutputView.showTicket(lottoTicket);

        Statistics statistics = rank(lottoTicket);
        OutputView.showStatistics(statistics);
    }

    private static LottoTicket publishLottoTicket() {
        Dollars dollars = new Dollars(InputView.getWon());
        List<LottoNumbers> manualLottoLines = toLottoLines(InputView.getManualLottoLines());
        return LottoTicket.publish(new PublishDetails(dollars, manualLottoLines), Collections::shuffle);
    }

    private static List<LottoNumbers> toLottoLines(List<String> stringLottoLines) {
        return stringLottoLines.stream()
                .map(IntegerParser::listOf)
                .map(LottoNumbers::of)
                .collect(Collectors.toList());
    }

    private static Statistics rank(LottoTicket lottoTicket) {
        String winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();
        return lottoTicket.rank(toLottoNumbers(winningNumbers), toLottoNumber(bonusNumber));
    }

    private static LottoNumbers toLottoNumbers(String winningNumbers) {
        return LottoNumbers.of(IntegerParser.listOf(winningNumbers));
    }

    private static LottoNumber toLottoNumber(int bonusNumber) {
        return LottoNumber.from(bonusNumber);
    }
}
