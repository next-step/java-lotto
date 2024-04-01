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

}
