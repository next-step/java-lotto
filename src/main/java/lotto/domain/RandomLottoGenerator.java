package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoNumber.LOTTO_MIN_NUMBER;

public class RandomLottoGenerator implements LottoGenerator {
    private final long automaticIssueQuantity;

    public RandomLottoGenerator(long automaticIssueQuantity) {
        this.automaticIssueQuantity = automaticIssueQuantity;
    }

    @Override
    public Lottos generate() {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < automaticIssueQuantity; i++) {
            lottos.add(getRandomLotto());
        }

        return new Lottos(lottos);
    }

    private Lotto getRandomLotto() {
        List<Integer> lottoNumberList = new ArrayList<>(LottoNumber.all());

        Collections.shuffle(lottoNumberList);
        int[] numbers = lottoNumberList.subList(0, LOTTO_NUMBER_COUNT).stream().mapToInt(i -> i).toArray();
        return new Lotto(numbers);
    }
}
