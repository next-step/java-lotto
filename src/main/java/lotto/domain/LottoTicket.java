package lotto.domain;

import lotto.domain.strategy.LottoTicketCreateStrategy;
import lotto.enums.Rank;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private static int TICKET_LIMIT = 6;
    private static int SECOND_PLACE_COUNT = 5;
    private static int TICKET_MIN_NUMBER = 1;
    private static int TICKET_MAX_NUMBER = 45;
    Set<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        validateTicketSize(lottoNumbers);
        validateLottoNumberRange(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    public static void validateTicketSize(List<Integer> lottoNumberList) {
        if (lottoNumberList.size() != TICKET_LIMIT) {
            throw new IllegalArgumentException("로또번호는 " + TICKET_LIMIT + "개를 입력하셔야합니다");
        }
    }

    public static void validateLottoNumberRange(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch(o -> o < TICKET_MIN_NUMBER || o > TICKET_MAX_NUMBER)) {
            throw new IllegalArgumentException("로또번호는 " + TICKET_MIN_NUMBER + "~" + TICKET_MAX_NUMBER + " 사이의 숫자로 입력해야합니다.");
        }
    }

    public int countSameNumber(List<Integer> target) {
        return (int) target.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    public boolean isContainNumber(int number) {
        return lottoNumbers.contains(number);
    }

    public Rank getRank(List<Integer> winningNumbers, int bonusBall) {
        return Rank.of(countSameNumber(winningNumbers), isBonusWin(winningNumbers, bonusBall));
    }

    public Set<Integer> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public boolean isBonusWin(List<Integer> winningNumbers, int bonusBall) {
        return countSameNumber(winningNumbers) == SECOND_PLACE_COUNT && isContainNumber(bonusBall);
    }
}
