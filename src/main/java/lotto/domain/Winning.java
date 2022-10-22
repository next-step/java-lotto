package lotto.domain;

import java.util.Objects;

public class Winning {
    private final Prize prize;
    private final LottoNumbers numbers;

    public Winning(final Prize prize, final LottoNumbers matchNumbers) {
        this.prize = prize;
        this.numbers = matchNumbers;
    }

    public int matchCount() {
        return prize.getMatchCount();
    }

    public int numberCount() {
        return numbers.count();
    }

    public long prize() {
        return prize.value();
    }
    
    public Money prizeMoney() {
        return prize.getMoney();
    }
    
    public boolean exist() {
        if (numbers == null) {
            return false;
        }
        return numbers.count() > 0;
    }

    public boolean hasPrize() {
        return prize.exist();
    }

    public boolean hasBonusNumber() {
        return prize.hasBonusNumber();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Winning winning = (Winning) o;
        return prize == winning.prize && Objects.equals(numbers, winning.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize, numbers);
    }

    @Override
    public String toString() {
        return "Winning{" +
               ", prize=" + prize +
               ", numbers=" + numbers +
               '}';
    }
}
