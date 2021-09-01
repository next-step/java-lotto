package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;

    public static final String LOTTO_SIZE_ERROR_MESSAGE = "로또의 갯수는 " + Lotto.LOTTO_SIZE + "자이어야 합니다.";
    public static final String LOTTO_NULL_MESSAGE = "로또에 null값을 넣을 수 없습니다.";

    private List<LottoNumber> lotto;

    public Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException(LOTTO_NULL_MESSAGE);
        }
        validateLottoNumbers(lottoNumbers);
        this.lotto = lottoNumbers.stream()
                .map(number -> new LottoNumber(number))
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public List<Integer> getValue() {
        return lotto.stream()
                .mapToInt(LottoNumber::getLottoNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean containNumber(LottoNumber number) {
        return lotto.contains(number);
    }

    public int sameLottoNumberCount(Lotto winningLottery) {
        return (int) lotto.stream()
                .filter(number -> winningLottery.containNumber(number))
                .count();
    }
}
