package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRandomGenerator extends LottoGenerator {
    private static final int LOTTO_NUMS = 6;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;


    public LottoRandomGenerator() {
    }

    @Override
    public List<Lotto> generatorLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(makeAutoLotto());
        }
        return lottos;
    }

    public Lotto makeAutoLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_NUM; i <= MAX_NUM; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.stream()
                .limit(LOTTO_NUMS)
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }
}
