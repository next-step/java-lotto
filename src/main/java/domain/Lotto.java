package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT_LIMIT = 6;
    private Set<LottoNumber> lottoNumbers;

    public Lotto(Integer... input) {
        this(Arrays.stream(input).collect(Collectors.toList()));
    }

    public Lotto(String input) {
        this(Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public Lotto(List<Integer> lottoNumbers) {
        Set<Integer> numbers = new HashSet<>(lottoNumbers);
        validateLottoNumberCount(numbers);

        this.lottoNumbers = lottoNumbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private static void validateLottoNumberCount(Set<Integer> lottoNumbers) {
        if (lottoNumbers.stream().count() < LOTTO_NUMBER_COUNT_LIMIT) {
            throw new IllegalArgumentException("로또 숫자는 6개 입니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }

    public int calculateMatchCount(WinningLotto winningLotto) {
        return (int) lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .filter(lottoNum -> winningLotto.getLottoNumbers().contains(lottoNum) || lottoNum == winningLotto.getBonusNumber())
                .count();
    }

    public boolean isMatchBonusNumber(WinningLotto winningLotto) {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .anyMatch(lottoNumber -> lottoNumber.equals(winningLotto.getBonusNumber()));
    }

}
