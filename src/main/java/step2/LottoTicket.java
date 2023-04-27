package step2;

import java.util.*;

public class LottoTicket {
    List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        validateDuplicatedLottoNumber(lottoNumbers);
        lottoNumbers.forEach(this::validateLottoNumberRange);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public void validateDuplicatedLottoNumber(List<Integer> lottoNumberList) {
        Set<Integer> lottoNumberSet = new HashSet<>(lottoNumberList);
        if (lottoNumberList.size() != lottoNumberSet.size()) {
            throw new IllegalArgumentException("로또번호는 중복되면 안됩니다.");
        }
    }

    public void validateLottoNumberRange(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("로또번호는 1~45 사이의 숫자로 입력해야합니다.");
        }
    }

    public static LottoTicket of(LottoTicketCreateStrategy strategy) {
        return new LottoTicket(strategy.getLottoNumbers());
    }

    public boolean isEquals(LottoTicket target) {
        return Arrays.equals(target.lottoNumbers.toArray(), lottoNumbers.toArray());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
