package lotto.model;

import lotto.model.generator.LottoGenerator;
import lotto.model.generator.ManualGenerator;
import lotto.model.generator.RandomLottoGenerator;
import lotto.model.generator.WinningGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private List<Lotto> lottos = new ArrayList<>();

    public LottoTicket buy(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.hasManualLotto()) {
            lottos.addAll(buyManualLotto(purchaseRequest.getManualLottoInfo()));
            purchaseRequest.spend(Lotto.PRICE.times(purchaseRequest.countOfManualLotto()));
        }

        Money amountOfRandomLotto = purchaseRequest.getMoney();
        int numberOfBuyLotto = amountOfRandomLotto.countAvailableLotto();
        if (numberOfBuyLotto > 0) {
            lottos.addAll(buyRandomLotto(numberOfBuyLotto));
        }
        return LottoTicket.of(lottos);
    }

    List<Lotto> buyManualLotto(List<String> inputOfLotto) {
        return inputOfLotto.stream()
                .map(lotto -> new ManualGenerator(lotto).generator())
                .collect(Collectors.toList());
    }

    List<Lotto> buyRandomLotto(int numberOfBuyLotto) {
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        return IntStream.range(0, numberOfBuyLotto)
                .mapToObj((value) -> lottoGenerator.generator())
                .collect(Collectors.toList());
    }

    public static WinningLotto generateWinningLotto(String inputOfNumbers, int inputOfBonusNumber) {
        return WinningGenerator.generate(inputOfNumbers, inputOfBonusNumber);
    }
}
