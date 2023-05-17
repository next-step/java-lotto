package controller;

import domain.*;
import domain.Number;
import dto.LottoBuyResult;
import util.LottoSeller;
import view.LottoInputView;
import view.LottoOutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoController {

    public void run() {
        final Money money = new Money(LottoInputView.inputPurchaseAmount());

        final Number manualLottoCount = new Number(LottoInputView.inputManualLottoCount());
        final Money change = LottoSeller.payManualLottoPrice(money, manualLottoCount);

        LottoOutputView.printInputManualLottoCount();
        final List<Lotto> manualLottos = IntStream.range(0, manualLottoCount.value())
                .mapToObj(i -> new Lotto(mapToLottoNumbers(LottoInputView.inputManualLottoNumbers())))
                .collect(Collectors.toList());

        final LottoBuyResult buyResult = LottoSeller.buyLotto(change);
        LottoOutputView.printLottoCount(buyResult.getLottos().size(), manualLottos.size());
        LottoOutputView.printLottoList(buyResult.getLottos());

        final WinningLotto winningLotto = inputWinningLotto();

        final List<LottoResult> results = Stream.concat(buyResult.getLottos().stream(), manualLottos.stream())
                .map(winningLotto::getResult)
                .collect(Collectors.toList());

        LottoOutputView.printLottoResult(new LottoStatistics(results));
    }

    private WinningLotto inputWinningLotto() {
        final List<LottoNumber> winningNumbers = LottoInputView.inputWinningLotto().stream()
            .map(String::trim)
            .map(LottoNumber::new)
            .distinct()
            .collect(Collectors.toList());

        final LottoNumber bonusNumber = new LottoNumber(LottoInputView.inputBonusNumber());

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private LottoNumber mapToLottoNumber(String number) {
        return new LottoNumber(number.trim());
    }

    private List<LottoNumber> mapToLottoNumbers(List<String> numbers) {
        return numbers.stream()
            .map(this::mapToLottoNumber)
            .collect(Collectors.toList());
    }
}
