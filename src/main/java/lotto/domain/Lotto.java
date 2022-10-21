package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto
{

    private static final int LOTTO_COUNT = 6;
    private final Set<LottoNumber> item;

    private Lotto(Set<LottoNumber> item) {
        this.item = item;
    }

    public static Lotto from(Set<Integer> item) {
        if (item.size() < LOTTO_COUNT)
        {
            throw new IllegalArgumentException("로또 번호의 갯수가 올바르지 않습니다");
        }
        return new Lotto(item.stream()
            .map(LottoNumber::from)
            .sorted()
            .collect(Collectors.toCollection(LinkedHashSet::new)));
    }

    public Set<LottoNumber> getItem() {
        return item;
    }

    public int compare(Set<LottoNumber> item) {
        return Math.toIntExact(this.item.stream()
            .filter(item::contains).count());
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
