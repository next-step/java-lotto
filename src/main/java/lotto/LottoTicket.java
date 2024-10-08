package lotto;

import java.util.List;

public class LottoTicket {
    public static final int LOTTO_NUMBERS_COUNT = 6;

    private final List<Integer> lottoNumbers;

    private LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket from(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
        if(lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호로 중복된 수를 사용할 수 없습니다.");
        }
        return new LottoTicket(lottoNumbers);
    }

    public boolean match(int targetNumber) {
        return lottoNumbers.contains(targetNumber);
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
