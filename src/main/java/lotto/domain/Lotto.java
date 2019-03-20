package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.LottoRandomNumberGenerator;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private List<Integer> lottoNumbers;

    public Lotto() {
        this.publish();
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private List<Integer> publish() {
        Set<Integer> numbers = new HashSet<>(LOTTO_SIZE);

        while (numbers.size() < LOTTO_SIZE) {
            numbers.add(LottoRandomNumberGenerator.next());
        }

        this.lottoNumbers = new ArrayList<>(numbers);

        Collections.shuffle(this.lottoNumbers);

        return this.lottoNumbers;
    }

    public int getContainsCount(final List<Integer> winningNumbers) {
        int containsCount = 0;

        for (Integer winningNumber : winningNumbers) {
            if (this.lottoNumbers.contains(winningNumber)) {
                containsCount++;
            }
        }

        return containsCount;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
            "lottoNumbers=" + lottoNumbers +
            '}';
    }
}
