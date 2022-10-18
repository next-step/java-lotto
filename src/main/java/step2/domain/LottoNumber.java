package step2.domain;

import java.util.Collections;
import java.util.List;

public class LottoNumber implements LottoNumberRange {
    private final List<Integer> lottoNumber;

    public boolean isInclude(int number) {
        return lottoNumber.contains(number);
    }

    public LottoNumber(List<Integer> LottoNumber) {
        validate(LottoNumber);
        this.lottoNumber = Collections.unmodifiableList(LottoNumber);
    }

    public int compareMatch(LottoNumber lottoNumber) {
        return (int) lottoNumber.getLottoNumber().stream()
                .filter(this.lottoNumber::contains)
                .count();
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    private void validate(List<Integer> LottoNumber) {
        LottoNumber.forEach(this::validateNumberRange);
//        String inValidNumber = LottoNumber.stream()
//                .filter(number -> number > 45 || number < 1)
//                .map(Object::toString)
//                .collect(Collectors.joining(", "));
//        if (inValidNumber.length() > 0) {
//            throw new IllegalArgumentException("번호는 1~45 정수여야 합니다. 허용되지 않은 입력: " + inValidNumber);
//        }
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
