package lottogame.model.lotto;

import static java.lang.String.join;
import static lottogame.model.lotto.LottoMachine.LOTTO_NUM_COUNT;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final Set<LottoNum> lottoNums;

    public Lotto(Set<LottoNum> lottoNums) {
        if (lottoNums.isEmpty()) {
            throw new IllegalArgumentException("로또 갯수가 유효하지 않습니다");
        }

        if (lottoNums.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("발행된 로또번호중 중복이 존재합니다");
        }

        this.lottoNums = lottoNums;
    }

    public int findMatchCountBy(Lotto otherLotto) {
        return (int) this.lottoNums.stream()
                .filter(otherLotto::isContain)
                .count();
    }

    public boolean isContain(LottoNum num) {
        return this.lottoNums.contains(num);
    }

    public String toString() {
        return "[" + join(", ", convertString()) + "]";
    }

    private List<String> convertString() {
        return new ArrayList<>(this.lottoNums).stream()
                .sorted()
                .map(LottoNum::toString)
                .toList();
    }
}
