package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int MAX_TICKET_NUMBERS = 6;

    private final List<LottoNumber> ticket;

    public Lotto(List<Integer> anyNumbers) {
        validation(anyNumbers);
        this.ticket = anyNumbers.stream().map(LottoNumber::from).collect(Collectors.toList());
    }

    private void validation(List<Integer> anyNumbers) {
        Set<Integer> temp = new HashSet<>();
        List<Integer> duplicated = anyNumbers.stream().filter(i -> !temp.add(i))
            .collect(Collectors.toList());
        if (!duplicated.isEmpty()) {
            throw new IllegalArgumentException(duplicated + " 중복된 숫자는 만들 수 없습니다.");
        }
    }

    public static Lotto from(List<Integer> anyNumbers) {
        return new Lotto(anyNumbers);
    }


    public int matchCount(Lotto lotto) {
        List<LottoNumber> difference = new ArrayList<>(this.ticket);
        difference.removeAll(lotto.ticket);
        return MAX_TICKET_NUMBERS - difference.size();
    }

    @Override
    public String toString() {
        return "Lotto{" +
            "ticket=" + ticket.toString() +
            '}';
    }

    public String lottoNumbers() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        ticket.forEach(lottoNumber -> {
            stringBuilder.append(lottoNumber.toString()).append(",");
        });
        int lastIndexOf = stringBuilder.lastIndexOf(",");
        stringBuilder.replace(lastIndexOf, lastIndexOf + 1, "]");
        return stringBuilder.toString();
    }
}
