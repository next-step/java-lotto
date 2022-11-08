package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_COUNT = 6;
    private final Set<LottoNumber> item;

    private Lotto(Set<LottoNumber> item) {
        this.item = item;
    }

    public static Lotto from(Set<Integer> item) {
        if (item.size() < LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호의 갯수가 올바르지 않습니다");
        }
        return new Lotto(item.stream()
            .map(LottoNumber::from)
            .sorted()
            .collect(Collectors.toCollection(LinkedHashSet::new)));
    }

    public void validBonusNumber(LottoNumber bonusNumber) {

        if (item.contains(bonusNumber)) {
            throw new IllegalArgumentException("해당 번호는 이미 등록된 번호 입니다.");
        }
    }

    public Set<LottoNumber> getItem() {
        return item;
    }

    public int compareLottoNumber(Set<LottoNumber> weekendLottoNumber) {
        return (int) item.stream()
            .filter(weekendLottoNumber::contains).count();
    }

    public boolean isBonusNumberContains(LottoNumber weekendBonusNumber) {
        return item.contains(weekendBonusNumber);
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
