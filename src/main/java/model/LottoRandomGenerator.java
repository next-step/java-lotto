package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRandomGenerator extends LottoGenerator {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static List<Lotto> lottos = new ArrayList<>();

    public LottoRandomGenerator() {
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    @Override
    public void generatorLotto(int count) {
        for (int i = 0; i < count; i++) {
            this.lottos.add(makeAutoLotto());
        }
    }

    public Lotto makeAutoLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_NUM; i <= MAX_NUM; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.stream()
                .limit(6)
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }
}
