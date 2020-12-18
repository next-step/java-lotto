package step2.domain.lotto;

import step2.domain.Rank;
import step2.domain.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;
import static step2.LottoNumberGenerator.*;

public class Lotto {
    private List<LottoNumbers> lotto = new ArrayList<>();
    private static final int LOTTO_PRICE = 1000;

    public Lotto(Request request) {
        this.buyLotto(request);
    }

    private void buyLotto(Request request) {
        int totalQuantity = request.getPurchaseMoney() / LOTTO_PRICE;
        for (int quantity = 0; quantity < totalQuantity; quantity++) {
            lotto.add(new LottoNumbers(provideLottoNumbers()));
        }
    }

    public List<LottoNumbers> getLotto() {
        return unmodifiableList(lotto);
    }

    public Map<Rank, List<Rank>> getWinLotto(List<Integer> targetNumbers, Integer bonusNumber) {
        return getLottoRanks(targetNumbers, bonusNumber).stream()
                .filter(r -> r != Rank.MISS)
                .collect(groupingBy(rank -> rank, toList()));
    }

    List<Rank> getLottoRanks(List<Integer> targetNumbers, Integer bonusNumber) {
        return lotto.stream()
                .map(numbers -> Rank.getRank(numbers.getEqualNumberCount(targetNumbers, bonusNumber)))
                .collect(toList());
    }
}
