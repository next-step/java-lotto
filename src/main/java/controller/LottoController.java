package controller;

import domain.*;
import domain.Number;
import dto.LottoBuyResult;
import dto.WinningLottoResult;
import util.LottoSeller;
import view.LottoInputView;
import view.LottoOutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoController {

    public void run() {
        final Wallet wallet = new Wallet(new Money(LottoInputView.inputPurchaseAmount()));

        final Number manualLottoCount = new Number(LottoInputView.inputManualLottoCount());
        LottoOutputView.printInputManualLottoCount();

        final List<Lotto> manualLottos = inputAndBuyManualLottos(manualLottoCount, wallet);
        final LottoBuyResult buyResult = LottoSeller.buyLotto(wallet.payAll());

        LottoOutputView.printLottoCount(buyResult, manualLottos);
        LottoOutputView.printLottoList(buyResult);

        final WinningLotto winningLotto = inputWinningLotto();

        final WinningLottoResult result = new WinningLottoResult(Stream.concat(buyResult.getLottos().stream(), manualLottos.stream())
                .map(winningLotto::getResult)
                .collect(Collectors.toList()));

        LottoOutputView.printLottoResult(new LottoStatistics(result));
    }

    private WinningLotto inputWinningLotto() {
        final List<LottoNumber> winningNumbers = LottoInputView.inputWinningLotto().stream()
            .map(String::strip)
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

    private List<Lotto> inputAndBuyManualLottos(Number manualLottoCount, Wallet wallet) {
        return IntStream.range(0, manualLottoCount.value())
                .mapToObj(i ->mapToLottoNumbers(LottoInputView.inputManualLottoNumbers()))
                .map(lottoNumbers -> {
                    LottoBuyResult lottoBuyResult = LottoSeller.buyManualLotto(lottoNumbers, wallet.payAll());
                    wallet.charge(lottoBuyResult.getChange());
                    return lottoBuyResult.getLottos();
                }).flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
