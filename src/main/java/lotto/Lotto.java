package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumberList;
    private final static int LOTTO_SIZE = 6;

    public static Lotto create(LottoGeneration generation) {
        List<Integer> numberList = generation.generate();
        if (numberList.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("요청하신 번호 배열이 로또 사이즈" + LOTTO_SIZE + "와 일치하지 않습니다.");
        }

        List<LottoNumber> lottoNumbers = numberList.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumberList = lottoNumbers;
    }

    public List<LottoNumber> numbers() {
        return this.lottoNumberList;
    }

    @Override
    public String toString() {
        return lottoNumberList.toString();
    }

    public int getCountMatchedLottoNumber(Lotto lotto) {
        return (int) numbers().stream()
                .filter(numbers -> lotto.contain(numbers))
                .count();
    }

    private boolean contain(LottoNumber otherLottoNumber) {
        return numbers().contains(otherLottoNumber);
    }
}
