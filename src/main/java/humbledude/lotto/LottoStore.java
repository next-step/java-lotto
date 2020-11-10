package humbledude.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    public static final int LOTTO_TICKET_PRICE = 1000;

    public static final int LOTTO_FIRST_PRIZE = 2_000_000_000;
    public static final int LOTTO_SECOND_PRIZE = 1_500_000;
    public static final int LOTTO_THIRD_PRIZE = 50_000;
    public static final int LOTTO_FOURTH_PRIZE = 5_000;

    private LottoWinningNumbers winningNumbers;
    private static final List<Integer> prizeList;

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

    public List<LottoTicket> buyAutoTickets(int budget) {
        int howMany = budget / LOTTO_TICKET_PRICE;

        return IntStream.range(0, howMany)
                .mapToObj(i -> AutoLotto.buildTicket())
                .collect(Collectors.toList());
    }

    public int claimPrize(LottoTicket ticket) {
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
