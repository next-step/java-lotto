package lottogame.model.lotto;

import static java.lang.String.join;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lottogame.model.winner.WinStandard;

public class Lotto {
    public static final int LOTTO_NUM_COUNT = 6;

    private final List<LottoNum> lottoNums;

    public Lotto(List<LottoNum> lottoNums) {
        if (lottoNums.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 갯수가 유효하지 않습니다");
        }

        if (new HashSet<>(lottoNums).size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("발행된 로또번호중 중복이 존재합니다");
        }

        Collections.sort(lottoNums);

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
        return this.lottoNums.stream()
                .map(LottoNum::toString)
                .toList();
    }
}
