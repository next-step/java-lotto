package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    static final int MAX_TICKET_NUMBERS = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> anyNumbers) {
        validation(anyNumbers);
        this.lottoNumbers = new HashSet<>(anyNumbers);
    }

    public static Lotto from(List<LottoNumber> anyNumbers) {
        return new Lotto(anyNumbers);
    }

    private void validation(List<LottoNumber> anyNumbers) {
        Set<LottoNumber> temp = new HashSet<>(anyNumbers);
        if (temp.size() != anyNumbers.size()) {
            List<LottoNumber> duplicated = anyNumbers.stream().filter(number -> !temp.add(number))
                .collect(Collectors.toList());
            throw new IllegalArgumentException(duplicated + " 중복된 숫자는 만들 수 없습니다.");
        }
    }

    public int matchCount(Lotto lotto) {
        List<LottoNumber> difference = new ArrayList<>(this.lottoNumbers);
        difference.removeAll(lotto.lottoNumbers);
        return MAX_TICKET_NUMBERS - difference.size();
    }

    public Set<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return "Lotto{" +
            "ticket=" + lottoNumbers.toString() +
            '}';
    }
}
