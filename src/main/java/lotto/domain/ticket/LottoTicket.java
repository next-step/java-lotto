package lotto.domain.ticket;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final Integer LOTTO_NUMBERS_SIZE = 6;
    public static final Long PRICE = 1000L;

    private List<LottoNumber> lottoNumbers;
    private LottoNumber bonusNumber;

    private LottoTicket(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoTicket of(List<Long> lottoNumbers, long bonusNumber) {
        return new LottoTicket(lottoNumbers.stream().map(LottoNumber::of).collect(Collectors.toList()), LottoNumber.of(bonusNumber));
    }

    private void validateSize(List<Long> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("Count of Lotto numbers must be 6");
        }
    }

    private void validateDuplicate(List<Long> lottoNumbers) {
        Set<Long> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
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

    public boolean existNumber(long number) {
        return lottoNumbers.contains(number);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
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
