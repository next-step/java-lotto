package lotto.domain;

import java.util.List;

public class LottoTicket {
    public static final int PRICE = 1000;
    private static final int COUNT_OF_LOTTO_NUMBER = 6;

    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format("로또번호는 반드시 %d개여야 합니다", COUNT_OF_LOTTO_NUMBER));
        }
    }
}
