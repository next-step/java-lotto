package nextstep.lotto.dto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static nextstep.lotto.constant.ExceptionMessage.INVALID_BONUS_NUMBER_CONTAINS_LOTTO_NUMBERS;

public class LottoWinnerNumbers extends LottoTicket {

    private final LottoNumber bonusNumber;

    private LottoWinnerNumbers(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        super(numbers);

        this.bonusNumber = bonusNumber;

        if (ticket.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_CONTAINS_LOTTO_NUMBERS);
        }
    }

    public static LottoWinnerNumbers create(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        return new LottoWinnerNumbers(numbers, bonusNumber);
    }

    public LottoRank matchCount(LottoTicket userLotto) {

        return LottoRank.of((int) this.ticket.stream()
                .filter(userLotto.ticket::contains)
                .count(), userLotto.ticket.contains(bonusNumber));
    }

    public List<LottoNumber> getLottoNumber() {
        return this.ticket.stream().sorted().collect(Collectors.toList());
    }
}
