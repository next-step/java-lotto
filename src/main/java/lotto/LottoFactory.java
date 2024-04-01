package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final int lottoPrice = 1000;
    private static final List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public List<Lotto> issueTicketsByMoney(int money) {
        int count = money / lottoPrice;
        List<Lotto> lottos = new ArrayList<>();
        while (count > 0) {
            lottos.add(createRandomLotto());
            count -= 1;
        }
        return lottos;
    }

    public static Lotto createLotto(Set<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static Lotto createRandomLotto() {
        Collections.shuffle(numbers);
        return createLotto(numbers
                .subList(0, 6)
                .stream()
                .collect(Collectors.toUnmodifiableSet()));
    }

    public List<Rank> getRankResults(Lotto winningLotto, List<Lotto> lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(winningLotto.getRank(lotto));
        }
        return ranks;
    }

    public double calculateRateOfReturn(Lotto winningLotto, List<Lotto> lottos) {
        double money = lottoPrice * lottos.size();
        double sumOfReward = 0;
        for (Lotto lotto : lottos) {
            sumOfReward += winningLotto.getReward(lotto);
        }
        return sumOfReward / money;
    }
}
