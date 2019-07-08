package lotto.domain;

import lotto.domain.generator.LottoNumbersGenerator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoTicket {
    private static final int LOTTO_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개이여야 합니다.");
        }

        lottoNumbers = numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTicket(LottoNumbersGenerator generator) {
        this(generator.generate());
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public int match(LottoTicket lottoTicket) {
        return (int) lottoNumbers.stream()
                .filter(lottoTicket::contains)
                .count();
    }
}
