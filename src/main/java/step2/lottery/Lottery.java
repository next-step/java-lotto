package step2.lottery;

import java.util.Set;

public class Lottery {
    private final Set<LotteryNumber> lottoNumbers;

    public Lottery(Set<LotteryNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int match(Set<LotteryNumber> numbers) {
        return (int) numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public Set<LotteryNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LotteryNumber number) {
        return lottoNumbers.contains(number);
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
