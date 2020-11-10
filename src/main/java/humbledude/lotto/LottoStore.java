package humbledude.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoStore {

    public static final long LOTTO_TICKET_PRICE = 1000;

    public static final long LOTTO_FIRST_PRIZE = 2_000_000_000;
    public static final long LOTTO_SECOND_PRIZE = 1_500_000;
    public static final long LOTTO_THIRD_PRIZE = 50_000;
    public static final long LOTTO_FOURTH_PRIZE = 5_000;

    private LottoWinningNumbers winningNumbers;
    private static final List<Long> prizeList;

    static {
        prizeList = Arrays.asList(
                LOTTO_FIRST_PRIZE,
                LOTTO_SECOND_PRIZE,
                LOTTO_THIRD_PRIZE,
                LOTTO_FOURTH_PRIZE);
    }

    public LottoStore() {}

    public void setWinningNumbers(LottoWinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<LottoTicket> buyAutoTickets(long budget) {
        long howMany = budget / LOTTO_TICKET_PRICE;

        return LongStream.range(0, howMany)
                .mapToObj(i -> AutoLotto.buildTicket())
                .collect(Collectors.toList());
    }

    public long claimPrize(List<LottoTicket> tickets) {
        return tickets.stream().map(this::claimPrize)
                .mapToLong(Long::longValue)
                .sum();
    }

    public long claimPrize(LottoTicket ticket) {
        if (winningNumbers == null) {
            throw new IllegalStateException("당첨번호가 입력되지 않았습니다.");
        }

        int matchedCount = winningNumbers.getMatchedCountWith(ticket);
        int grade = getGrade(matchedCount);

        if (grade > prizeList.size() - 1) {
            return 0;
        }
        return prizeList.get(grade);
    }

    private int getGrade(int matchedCount) {
        return LottoNumbers.LOTTO_SIZE_OF_NUMBERS - matchedCount;
    }

}
