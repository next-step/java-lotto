package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = changeNumbersToLottoNumber(lotto);
    }

    public List<LottoNumber> changeNumbersToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<Integer> convertLottoNumbers() {
        return lotto.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    /**
     * 생성된 로또 번호와 지난주 당첨 번호 중 같은 번호가 있는지 확인 후 갯수 반환
     * @param targetNumbers 지난주 당첨 번호
     * @return long
     */
    public long getEqualCount(List<Integer> targetNumbers) {
        return lotto.stream()
                .filter(lottoNumber -> targetNumbers.contains(lottoNumber.getNumber()))
                .count();
    }
}
