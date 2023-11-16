package lotto.domain;

import lotto.util.Parser;
import lotto.util.Splitter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1_000;
    private final Lottos lottos;


    public LottoMachine(Money money) {
        this.lottos = Lottos.of(calcPossibleLottoCount(money));
    }

    public LottoMachine(Money money, List<String> manualNumbers) {
        int autoLottoCount = calcAutoLottoCount(money, manualNumbers.size());

        List<List<Integer>> manualLottoNumbers = manualNumbers.stream()
                .map(Splitter::splitString)
                .map(
                        lottoNumber -> Arrays.stream(lottoNumber)
                        .map(Parser::parseInteger)
                        .collect(Collectors.toList())
                )
                .collect(Collectors.toUnmodifiableList());

        this.lottos = Lottos.createLottos(autoLottoCount, manualLottoNumbers);
    }

    private int calcPossibleLottoCount(Money money) {
        return (int) money.getMoney() / LOTTO_PRICE;
    }

    private int calcAutoLottoCount(Money money, int manualLottoCount) {
        return calcPossibleLottoCount(money) - manualLottoCount;
    }

    public Lottos getLottoTickets() {
        return this.lottos;
    }
}
