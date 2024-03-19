package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumberList;
    private final static int LOTTO_SIZE = 6;

    public static Lotto create(LottoGeneration generation) {
        return new Lotto(generation);
    }

    private Lotto(LottoGeneration generation) {
        List<Integer> numberList = generation.generate();
        if (numberList.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("요청하신 번호 배열이 로또 사이즈" + LOTTO_SIZE + "와 일치하지 않습니다.");
        }

        this.lottoNumberList = numberList.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> numbers() {
        return this.lottoNumberList;
    }

    @Override
    public String toString() {
        return lottoNumberList.toString();
    }
}
