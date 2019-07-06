package lotto.domain.ticket;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final Integer LOTTO_NUMBERS_SIZE = 6;
    public static final Long PRICE = 1000L;

    private List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(List<Long> lottoNumbers) {
        return new LottoTicket(lottoNumbers.stream().map(LottoNumber::of).collect(Collectors.toList()));
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("Count of Lotto numbers must be 6");
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("Lotto numbers can not be duplicated");
        }
    }

    public List<LottoNumber> findAll() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public String getLottoTicketNumbers() {
        return String.join(", ", getNumbers());
    }

    public boolean existNumber(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    private List<String> getNumbers() {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
