package study.lotto.domain;

import study.lotto.domain.exception.IllegalLottoNumberSizeException;
import study.lotto.domain.exception.NoDuplicatedNumberAllowedException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket implements Iterable<LottoNumber> {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String LOTTO_NUMBERS_SIZE_ERROR_MESSAGE =
            "%d개의 로또 숫자를 입력하세요.";
    private static final String DUPLICATED_LOTTO_NUMBERS_ERROR_MESSAGE =
            "로또 숫자의 중복은 허용되지 않습니다.";
    public static final int PRICE = 1000;

    private Set<LottoNumber> lottoNumbers;

    private LottoTicket() {
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) ||
                lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalLottoNumberSizeException(
                    String.format(LOTTO_NUMBERS_SIZE_ERROR_MESSAGE,
                            LOTTO_NUMBERS_SIZE));
        }

        setLottoNumbers(lottoNumbers);

        if (this.lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new NoDuplicatedNumberAllowedException(
                    DUPLICATED_LOTTO_NUMBERS_ERROR_MESSAGE);
        }
    }

    public LottoTicket(LottoTicket lottoTicket) {
        this.lottoNumbers = lottoTicket.lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public int size() {
        return lottoNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
    }

    private void setLottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = new HashSet<>();
        for (int number : lottoNumbers) {
            this.lottoNumbers.add(new LottoNumber(number));
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }
}
