package step2;

import java.util.List;

public class Lottery {
    private final List<Integer> lottoNumbers;

    public Lottery(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int match(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Lottery) {
            Lottery other = (Lottery) obj;
            return lottoNumbers.equals(other.lottoNumbers);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return lottoNumbers.hashCode();
    }
}
