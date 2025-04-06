package lotto.domain;

import lotto.strategy.LottoStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int REQUIRED_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(String input) {
        this(createLottoTicket(input));
    }

    public List<LottoNumber> getLottoTicket() {
        return lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> uniqueNumbers = lottoNumbers.stream().collect(Collectors.toSet());

        if (uniqueNumbers.size() != REQUIRED_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않은 6개의 숫자여야 합니다.");
        }
    }

    public static LottoTicket generateLottoNumbers(LottoStrategy lottoStrategy) {
        List<LottoNumber> generatedNumbers = lottoStrategy.generateLottoNumbers();
        return new LottoTicket(generatedNumbers);
    }

    static List<LottoNumber> createLottoTicket(String input) {
        List<LottoNumber> lottoNumbers = Arrays.stream(input.trim().split(","))
                .map(String::trim)        // 각 번호의 공백 제거
                .map(Integer::parseInt)   // 문자열을 숫자로 변환
                .map(LottoNumber::of)     // 숫자를 LottoNumber로 변환
                .collect(Collectors.toList()); // List<LottoNumber>로 수집
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }
}
