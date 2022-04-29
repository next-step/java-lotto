package lotto.dto;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WinnerLotto {
    private static final String DELIMITER = ", ";
    private static final int LOTTO_SIZE = 6;

    private final Lotto lotto;

    public WinnerLotto(String lottoNumbers) {
        validate(lottoNumbers);
        this.lotto = getLotto(lottoNumbers);
    }

    private void validate(String lottoNumbers) {
        Objects.requireNonNull(lottoNumbers, "로또 당첨 번호는 null일 수 없습니다.");
        if (lottoNumbers.isBlank()) {
            throw new IllegalArgumentException("로또 당첨 번호는 빈 값일 수 없습니다.");
        }
    }

    private Lotto getLotto(String lottoNumbers) {
        Set<LottoNumber> lotto = splitNumbers(lottoNumbers);

        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 당첨 번호는 6개로 이루어져야 합니다. lottos:" + lottoNumbers);
        }

        return new Lotto(lotto);
    }

    private Set<LottoNumber> splitNumbers(String lottoNumbers) {
        try {
            Set<LottoNumber> lotto = Arrays
                    .stream(lottoNumbers.split(DELIMITER))
                    .map(LottoNumber::new)
                    .collect(Collectors.toSet());
            return lotto;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 당첨 번호 입력이 올바르지 않습니다. ', '로 구분해서 숫자 6개를 입력해주세요. lottos:" + lottoNumbers);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }
}
