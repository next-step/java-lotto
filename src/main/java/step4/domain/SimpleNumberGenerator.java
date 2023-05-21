package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SimpleNumberGenerator implements NumberGenerator {
    private final List<LottoNumber> candidateNumbers = new ArrayList<>();

    public SimpleNumberGenerator() {
        fillNumbers();
    }

    private void fillNumbers() {
        for (int i = 0; i < LottoNumber.MAX_LOTTO_NUMBER; i++) {
            candidateNumbers.add(new LottoNumber(i + 1));
        }
    }

    @Override
    public List<LottoNumber> generateNumbers() {
        shuffle();
        List<LottoNumber> generated = getSixNumbers();
        sort(generated);
        return generated;
    }

    private void shuffle() {
        Collections.shuffle(candidateNumbers, new Random());
    }

    private List<LottoNumber> getSixNumbers() {
        // 깊은 복사를 위해 stream 활용
        return candidateNumbers.subList(0, 6).stream().collect(Collectors.toList());
    }

    private void sort(List<LottoNumber> numbers) {
        Collections.sort(numbers);
    }
}
