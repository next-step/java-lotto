package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {

    static final int ONE_LOTTO_AMOUNT = 1000;

    private List<Lotto> publishLotto;

    public LottoPublisher(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.publishLotto = publishLottos(purchaseAmount / 1000);
    }

    public LottoPublisher(List<Lotto> publishLotto) {
        this.publishLotto = publishLotto;
    }

    public LottoPublisher() {
    }

    void validatePurchaseAmount(int amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("투입금액은 0이하의 숫자를 입력할 수 없습니다.");
        }
        if (0 < amount%1000) {
            throw new IllegalArgumentException("투입금액은 1000으로 나누었을때 나머지가 없어야 합니다.");
        }
    }

    private List<Lotto> publishLottos(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < buyCount; count++) {
            LottoNumber lottoNumber = new LottoNumber();
            lottos.add(new Lotto(lottoNumber.getNumbers()));
        }
        return lottos;
    }

    public double getRevenueRatio(int rewardWinningMoney) {
        if (rewardWinningMoney == 0)
            return 0d;
        return (double)rewardWinningMoney / (double)getPurchaseAmount();
    }

    public List<Rank> getPublishLottoRanks(WinnerLotto winnerLotto) {
        List<Rank> lottoRanks = new ArrayList<>();
        for (Lotto lotto : publishLotto) {
            Rank rank = getRank(winnerLotto.getNumbers(), lotto.getNumbers());
            lottoRanks.add(rank);
        }
        return lottoRanks;
    }

    private Rank getRank(List<Integer> winNumbers, List<Integer> numbers) {
        int sameWinNumberCount = 0;
        for (Integer winNumber : winNumbers) {
            sameWinNumberCount = getSameWinNumbers(numbers, winNumber, sameWinNumberCount);
        }
        return Rank.valueOf(sameWinNumberCount);
    }

    private int getSameWinNumbers(List<Integer> numbers, Integer winNumber, int sameWinNumberCount) {
        if (numbers.contains(winNumber)) {
            sameWinNumberCount++;
        }
        return sameWinNumberCount;
    }

    public List<List<Integer>> getLottosNumbers() {
        List<List<Integer>> lottosNumbers = new ArrayList<>();
        for (Lotto lotto : publishLotto) {
            lottosNumbers.add(lotto.getNumbers());
        }
        return lottosNumbers;
    }

//    public int getBuyLottoCount() {
//        return publishLotto.size();
//    }

    public int getPurchaseAmount() {
        return publishLotto.size() * ONE_LOTTO_AMOUNT;
    }

    public List<Lotto> getPublishLotto() {
        return publishLotto;
    }
}
