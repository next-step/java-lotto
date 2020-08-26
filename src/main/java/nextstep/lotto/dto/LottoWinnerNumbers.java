package nextstep.lotto.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static nextstep.lotto.constant.ExceptionMessage.INVALID_BONUS_NUMBER_CONTAINS_LOTTO_NUMBERS;

public class LottoWinnerNumbers extends LottoTicket {

    private LottoNumber bonusNumber;

    private LottoWinnerNumbers(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        super(numbers);

        ticket = numbers.stream().collect(Collectors.toSet());
        this.bonusNumber = bonusNumber;

        if (ticket.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_CONTAINS_LOTTO_NUMBERS);
        }
    }

    public static LottoWinnerNumbers create(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        return new LottoWinnerNumbers(numbers, bonusNumber);
    }

    public LottoRank matchCount(List<LottoNumber> userLotto) {

        return LottoRank.of((int) ticket.stream()
                .filter(userLotto::contains)
                .count(), userLotto.contains(bonusNumber));
    }

    public List<LottoNumber> getLottoNumber() {
        List<LottoNumber> lottoTicket = this.ticket.stream().collect(Collectors.toList());
        Collections.sort(lottoTicket);
        return Collections.unmodifiableList(
                lottoTicket
        );
    }
}
