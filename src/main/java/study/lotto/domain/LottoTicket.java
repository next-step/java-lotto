package study.lotto.domain;

import study.lotto.domain.exception.LottoTicketConstructorException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket implements Iterable<LottoNumber> {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String LOTTO_NUMBERS_SIZE_ERROR_MESSAGE =
            "%d개의 로또 숫자를 입력하세요.";
    private static final String DUPLICATED_LOTTO_NUMBERS_ERROR_MESSAGE =
            "로또 숫자의 중복은 허용되지 않습니다.";
    public static final int PRICE = 1000;

    private Set<LottoNumber> lottoNumber;

    private LottoTicket() {
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) ||
                lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoTicketConstructorException(
                    LOTTO_NUMBERS_SIZE_ERROR_MESSAGE);
        }

        setLottoNumber(lottoNumbers);

        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoTicketConstructorException(
                    DUPLICATED_LOTTO_NUMBERS_ERROR_MESSAGE);
        }
    }

    public int size() {
        return lottoNumber.size();
    }

    public List<LottoNumber> getLottoNumber() {
        return lottoNumber.stream()
                .map(LottoNumber::clone)
                .sorted()
                .collect(Collectors.toList());
    }

    private void setLottoNumber(List<Integer> lottoNumbers) {
        lottoNumber = new HashSet<>();
        for (int number : lottoNumbers) {
            lottoNumber.add(new LottoNumber(number));
        }
    }

    public LottoTicket clone() {
        LottoTicket clonedLottoTicket = new LottoTicket();
        clonedLottoTicket.lottoNumber = lottoNumber.stream()
                .map(LottoNumber::clone)
                .collect(Collectors.toSet());

        return clonedLottoTicket;
    }

    @Override public Iterator<LottoNumber> iterator() {
        return lottoNumber.iterator();
    }
}
