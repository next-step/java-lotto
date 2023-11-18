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
        this.lottos = Lottos.of(calcAutoLottoCount(money, manualNumbers.size()));
        List<List<Integer>> manualLottoNumbers = parseManulNumbers(manualNumbers);

        manualLottoNumbers.stream()
                .map(Lotto::new)
                .forEach(this.lottos::addLotto);
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    public int countTotalLotto() {
        return this.lottos.countLottoSize();
    }

    private int calcPossibleLottoCount(Money money) {
        return (int) money.getMoney() / LOTTO_PRICE;
    }

    private int calcAutoLottoCount(Money money, int manaulLottoCount) {
        return calcPossibleLottoCount(money) - manaulLottoCount;
    }

    private List<List<Integer>> parseManulNumbers(List<String> manualNumbers) {
        return manualNumbers.stream()
                .map(Splitter::splitString)
                .map(lottoNumber -> Arrays.stream(lottoNumber)
                        .map(Parser::parseInteger)
                        .collect(Collectors.toList()))
                .collect(Collectors.toUnmodifiableList());
    }
}
