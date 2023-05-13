package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Lottos {
    private List<Lotto> lottoList;

    public Lottos(LottoPurchaseAmount amount) {
        lottoList = generateRandomLottos(amount.calculateQuantity());
    }

    public Lottos(LottoPurchaseAmount amount, List<List<LottoNumber>> inNumbersList) {
        validateExceededAvailableCount(inNumbersList, amount.calculateQuantity());

        lottoList = inNumbersList.stream()
                .map(inNumbers -> new Lotto(inNumbers))
                .collect(Collectors.toList());

        lottoList.addAll(generateRandomLottos(amount.calculateQuantity() - inNumbersList.size()));
    }

    private List<Lotto> generateRandomLottos(int availablePurchaseCount) {
        List<Lotto> resultList = new ArrayList();

        for (int i = 0; i < availablePurchaseCount; i++) {
            resultList.add(new Lotto());
        }

        return resultList;
    }

    private void validateExceededAvailableCount(List<List<LottoNumber>> inNumbersList, int availablePurchaseCount) {
        if (inNumbersList.size() > availablePurchaseCount){
            throw new IllegalArgumentException(String.format("Possible to purchase %d tickets with the given amount, but received numbers for %d tickets.", availablePurchaseCount, inNumbersList.size()));
        }
    }

    public LottoResult getWinningResult(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();

        lottoList.stream()
                .map(lotto -> Rank.rankOf(winningLotto.countMatchingWith(lotto), winningLotto.containsBonus(lotto)))
                .filter(rank -> rank != Rank.NON_RANKED)
                .forEach(rank -> lottoResult.put(rank));

        return lottoResult;
    }

    public int count() {
        return lottoList.size();
    }

    public int getRandomLottoCount() {
        return (int) lottoList.stream()
                .filter(lotto -> lotto.isRandom())
                .count();
    }

    @Override
    public String toString() {
        return lottoList.stream()
                .map(lotto -> lotto.toString())
                .collect(Collectors.joining("\n"));
    }
}
