package lotto.domain;

import static lotto.util.Constant.LOTTO_SIZE;
import static lotto.util.Constant.MAX_NUMBER;
import static lotto.util.Constant.MIN_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberStrategy implements NumberGenerateStrategy {

    private final List<Integer> lottoNumberBalls = makeNumbers();

    private List<Integer> makeNumbers() {
        final List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }

    @Override
    public List<LottoNumber> generateLottoNumber() {
        Collections.shuffle(lottoNumberBalls);
        List<Integer> picked = lottoNumberBalls.subList(0, LOTTO_SIZE);
        Collections.sort(picked);
        return picked.stream().map(LottoNumber::from).collect(Collectors.toList());
    }
}
