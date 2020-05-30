package lotto;

import java.util.*;

public class LottoTicket {

    private static final int DEFAULT_SIZE = 6;

    private Set<Integer> lottoNumbers;

    private LottoTicket(List<Integer> lottoNumbers) {

        if (Objects.isNull(lottoNumbers)) {
            throw new NullPointerException();
        }

        Set lottoSet = new TreeSet<>(lottoNumbers);
        validate(lottoSet);

        this.lottoNumbers = lottoSet;
    }

    public static LottoTicket of(List<Integer> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(Integer number) {
        return lottoNumbers.contains(number);
    }

    private void validate(Set lottoSet) {
        validateSize(lottoSet.size());
    }

    private void validateSize(int size) {
        if (size < DEFAULT_SIZE) {
            throw new IllegalArgumentException("로또 번호의 개수가 알맞지 않습니다.");
        }
    }
}
