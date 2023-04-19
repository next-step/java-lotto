package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<LottoNumber> numbers;

    public Lotto(final int... numbers){
        this(
            Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }
    public Lotto(final  List<LottoNumber> numbers){
        this(new HashSet<>(numbers));
    }

    public Lotto(final Set<LottoNumber> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException("로또번호는 6개여야 합니다.");
        }
        this.numbers = numbers;
    }

    public boolean contains(final LottoNumber number){
        return numbers.contains(number);
    }

    public int match(final Lotto lotto){
        return (int) numbers.stream()
                .filter(it ->lotto.contains(it))
                .count();
    }
}
