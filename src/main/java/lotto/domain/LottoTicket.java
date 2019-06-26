package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final Integer LOTTO_NUMBERS_SIZE = 6;
    public static final Long PRICE = 1000L;

    private List<Long> lottoNumbers;

    private LottoTicket(List<Long> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(List<Long> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
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

    public List<Long> findAll() {
        return new ArrayList<>(lottoNumbers);
    }

    public String getLottoTicketNumbers() {
        return String.join(", ", getNumbers());
    }

    public boolean existNumber(long number) {
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
