package lotto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoVendingMachine {
    private List<Lotto> lottos;

    private final int UNIT_PRICE = 1000;

    public LottoVendingMachine() {
        this.lottos = new ArrayList<>();
    }

    public LottoVendingMachine buyLottos(int amount, LottoGenerator lottoGenerator){
        int buyLottoCnt = this.howManyLotto(amount);
        this.createLottos(buyLottoCnt, lottoGenerator);
        return this;
    }

    public int howManyLotto(int amount) {
        return amount / UNIT_PRICE;
    }

    public void createLottos(int quantity, LottoGenerator lottoGenerator) {
        for (int i = 0; i < quantity; i++) {
            this.lottos.add(createLotto(lottoGenerator));
        }
    }
    public Lotto createLotto(LottoGenerator lottoGenerator) {
        return new Lotto(lottoGenerator.lottoGeneration());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public int getUnitPrice() {
        return UNIT_PRICE;
    }

    public List<Integer> resultLottoGames(String result) {
        List<Integer> winningNumbers = getIntegers(result);
        return lottos.stream()
                .filter(lotto -> lotto.howManySameLottoNumber(winningNumbers) >= 3)
                .map(x -> x.howManySameLottoNumber(winningNumbers))
                .collect(Collectors.toList());
    }

    private List<Integer> getIntegers(String result) {
        return Arrays.stream(result.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
