package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int SINGLE_LOTTO_PRICE = 1000;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(Integer... input) {
        this(Arrays.stream(
                Optional.ofNullable(input).orElseGet(() -> new Integer[0]))
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(String[] input) {
        this(Arrays.stream(
                Optional.ofNullable(input).orElseGet(() -> new String[0]))
                .map(Integer::valueOf)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> input) {
        validatePolicy(input);
        this.lottoNumbers = input;
    }

    private void validatePolicy(List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 로또 번호로 구성되어야 합니다.");
        }
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < SINGLE_LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액은 최소 1000원 이상이어야 합니다.");
        }
    }

    public List<LottoNumber> values() {
        return lottoNumbers;
    }
}
