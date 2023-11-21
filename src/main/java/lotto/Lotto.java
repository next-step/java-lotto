package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    static final int MAX_TICKET_NUMBERS = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> anyNumbers) {
        validation(anyNumbers);
        this.lottoNumbers = anyNumbers.stream().map(LottoNumber::from).collect(Collectors.toSet());
    }

    public static Lotto from(List<Integer> anyNumbers) {
        return new Lotto(anyNumbers);
    }

    private void validation(List<Integer> anyNumbers) {
        Set<Integer> temp = new HashSet<>(anyNumbers);
        if (temp.size() != anyNumbers.size()) {
            List<Integer> duplicated = anyNumbers.stream().filter(i -> !temp.add(i))
                .collect(Collectors.toList());
            throw new IllegalArgumentException(duplicated + " 중복된 숫자는 만들 수 없습니다.");
        }
    }

    public int matchCount(Lotto lotto) {
        List<LottoNumber> difference = new ArrayList<>(this.lottoNumbers);
        difference.removeAll(lotto.lottoNumbers);
        return MAX_TICKET_NUMBERS - difference.size();
    }

    public String lottoNumbers() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        lottoNumbers.forEach(lottoNumber -> {
            stringBuilder.append(lottoNumber.toString()).append(",");
        });
        int lastIndexOf = stringBuilder.lastIndexOf(",");
        stringBuilder.replace(lastIndexOf, lastIndexOf + 1, "]");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Lotto{" +
            "ticket=" + lottoNumbers.toString() +
            '}';
    }
}
