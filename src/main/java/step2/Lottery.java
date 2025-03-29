package step2;

import java.util.List;
import java.util.stream.Collectors;

public class Lottery {
    private final List<LotteryNumber> lottoNumbers;

    public Lottery(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() < 6) {
            throw new IllegalArgumentException("로또 번호는 6개 이상이어야 합니다.");
        }
        this.lottoNumbers = lottoNumbers.stream().map(LotteryNumber::new).collect(Collectors.toList());
    }

    public int match(List<LotteryNumber> numbers) {
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
