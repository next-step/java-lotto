package dev.dahye.lotto.domain;

import java.util.*;

public class LottoTicket {
    private static final int MAX_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<Integer> lottoNumbers) {
        validateLottoNumberIsNotNull(lottoNumbers);
        Collections.sort(lottoNumbers);
        validateLottoNumberSize(lottoNumbers);
        validateDuplicateNumbers(lottoNumbers);

        this.lottoNumbers = convertLottNumber(lottoNumbers);
    }

    private void validateLottoNumberIsNotNull(List<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("lottoNumbers는 null이거나 빈 값일 수 없습니다.");
        }
    }

    public static LottoTicket autoIssued() {
        return new LottoTicket(LottoNumberExtractor.createShuffled(MAX_SIZE));
    }

    public static LottoTicket manualIssued(List<Integer> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    private void validateLottoNumberSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("로또 티켓은 6자리 숫자여야 합니다.");
        }
    }

    private List<LottoNumber> convertLottNumber(List<Integer> lottoNumbers) {
        List<LottoNumber> convertedLottoNumbers = new ArrayList<>();

        for (Integer lottoNumber : lottoNumbers) {
            convertedLottoNumbers.add(LottoNumber.of(lottoNumber));
        }

        return convertedLottoNumbers;
    }

    private void validateDuplicateNumbers(List<Integer> lottoNumbers) {
        Set<Integer> deduplicatedNumbers = new HashSet<>(lottoNumbers);
        if (deduplicatedNumbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("로또 티켓에는 중복된 숫자가 없어야 합니다.");
        }
    }

    public int getCountOfMatch(LottoTicket lottoTicket) {
        return (int) lottoTicket.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    public boolean contains(LottoNumber number) {
        return this.lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(number));
    }
}
