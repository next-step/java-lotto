package step2.model;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;
import step2.exception.LottoLengthException;

public class Lotto {

    public final static int SIZE = 6;
    public static final long PRICE = 1000L;

    private final SortedSet<LottoNumber> lottoNumbers;

    public Lotto(SortedSet<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Stream<LottoNumber> stream() {
        return lottoNumbers.stream();
    }

    public static Lotto of(List<LottoNumber> lottoNumbers) {
        return new Lotto(new TreeSet<>(lottoNumbers));
    }

    public int checkWinningCount(Lotto winningLotto) {
        Set<LottoNumber> temp = new TreeSet<>(lottoNumbers);
        temp.retainAll(winningLotto.lottoNumbers);
        return temp.size();
    }

    public boolean has(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    private static void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new LottoLengthException();
        }
    }
}