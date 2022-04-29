package lotto.dto;

import lotto.model.LottoNumber;
import lotto.model.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinnerLottos {
    private static final String DELIMITER = ", ";
    private static final int LOTTO_SIZE = 6;

    private final Lottos lottos;

    public WinnerLottos(String lottoNumbers) {
        validate(lottoNumbers);
        this.lottos = getLottos(lottoNumbers);
    }

    private void validate(String lottoNumbers) {
        Objects.requireNonNull(lottoNumbers, "로또 당첨 번호는 null일 수 없습니다.");
        if (lottoNumbers.isBlank()) {
            throw new IllegalArgumentException("로또 당첨 번호는 빈 값일 수 없습니다.");
        }
    }

    private Lottos getLottos(String lottoNumbers) {
        List<LottoNumber> lottos = splitNumbers(lottoNumbers);

        if (lottos.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 당첨 번호는 6개로 이루어져야 합니다. lottos:" + lottoNumbers);
        }

        return new Lottos(lottos);
    }

    private List<LottoNumber> splitNumbers(String lottoNumbers) {
        try {
            List<LottoNumber> lottos = Arrays
                    .stream(lottoNumbers.split(DELIMITER))
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
            return lottos;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 당첨 번호 입력이 올바르지 않습니다. ', '로 구분해서 숫자 6개를 입력해주세요. lottos:" + lottoNumbers);
        }
    }

    public Lottos getLottos() {
        return lottos;
    }
}
