package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final double LOTTO_NUBERS_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(String[] lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .map(s -> LottoNumber.of(Integer.parseInt(s.trim())))
                .collect(Collectors.toList()));
    }

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUBERS_SIZE) {
            throw new IllegalArgumentException("로또 티켓의 로또 숫자는 6개이어야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
