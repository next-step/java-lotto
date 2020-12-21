package step2.domain.lotto;

import step2.domain.LottoRequest;
import step2.domain.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;
import static step2.LottoNumberGenerator.*;

public class Lotto {
    private List<LottoNumbers> lotto = new ArrayList<>();
    private static final int LOTTO_PRICE = 1000;

    public Lotto(LottoRequest lottoRequest) {
        this.buyLotto(lottoRequest);
    }

    private void buyLotto(LottoRequest lottoRequest) {
        int totalQuantity = lottoRequest.getPurchaseMoney() / LOTTO_PRICE;
        for (int quantity = 0; quantity < totalQuantity; quantity++) {
            lotto.add(new LottoNumbers(provideLottoNumbers()));
        }
    }

    public List<LottoNumbers> getLotto() {
        return unmodifiableList(lotto);
    }

    public Map<Rank, Long> getWinLotto(LottoNumbers targetNumbers, LottoNumber bonusNumber) {
        return getLottoRanks(targetNumbers, bonusNumber).stream()
                .filter(r -> r != Rank.MISS)
                .collect(groupingBy(rank -> rank, counting()));
    }

    List<Rank> getLottoRanks(LottoNumbers targetNumbers, LottoNumber bonusNumber) {
        return lotto.stream()
                .map(numbers -> numbers.getRankOfLottoNumbers(targetNumbers, bonusNumber))
                .collect(toList());
    }
}
