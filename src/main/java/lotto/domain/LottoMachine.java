package lotto.domain;

import lotto.util.Parser;
import lotto.util.Splitter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1_000;
    private final Lottos lottos;
    private final Lottos manaulLottos;


    public LottoMachine(Money money) {
        this.lottos = Lottos.of(calcPossibleLottoCount(money));
        this.manaulLottos = Lottos.of(0);
    }

    public LottoMachine(Lottos lottos, Lottos manaulLottos) {
        this.lottos = lottos;
        this.manaulLottos = manaulLottos;
    }

    public static LottoMachine buyLottos(Money money, List<String> manualNumbers) {
        int autoLottoCount = calcAutoLottoCount(money, manualNumbers.size());

        return new LottoMachine(Lottos.of(autoLottoCount), Lottos.of(parseManulNumbers(manualNumbers)));
    }

    public Lottos getLottoTickets() {
        List<Lotto> totalLottos = this.lottos.sumLottos(this.manaulLottos);
        return new Lottos(totalLottos);
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Lottos getManaulLottos() {
        return manaulLottos;
    }

    private static int calcPossibleLottoCount(Money money) {
        return (int) money.getMoney() / LOTTO_PRICE;
    }

    private static int calcAutoLottoCount(Money money, int manualLottoCount) {
        return calcPossibleLottoCount(money) - manualLottoCount;
    }

    private static List<List<Integer>> parseManulNumbers(List<String> manualNumbers) {
        return manualNumbers.stream()
                .map(Splitter::splitString)
                .map(lottoNumber -> Arrays.stream(lottoNumber)
                        .map(Parser::parseInteger)
                        .collect(Collectors.toList()))
                .collect(Collectors.toUnmodifiableList());
    }
}
