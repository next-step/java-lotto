package step2.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoTicket extends LottoTicket {

    private final LottoNumber bonusLottoNumber;

    public WinningLottoTicket(List<LottoNumber> numbers, LottoNumber bonusLottoNumber) {
        super(numbers);

        validateDuplicateBonusLottoNumber(numbers, bonusLottoNumber);

        this.bonusLottoNumber = bonusLottoNumber;
    }

    private void validateDuplicateBonusLottoNumber(List<LottoNumber> numbers, LottoNumber bonusLottoNumber) {
        if (numbers.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다. - " + bonusLottoNumber);
        }
    }

    public static WinningLottoTicket createBy(List<Integer> numbers, LottoNumber bonusLottoNumber) {
        List<LottoNumber> LottoNumbers = numbers.stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());

        return new WinningLottoTicket(LottoNumbers, bonusLottoNumber);
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }
}
