package lotto.domain.product.lotto;

import java.util.Set;

public class WinningTicket extends LotteryTicket {

    private final LottoNumber bonusNumber;

    public WinningTicket(LotteryTicket lotteryTicket, LottoNumber bonusNumber) {
        super(lotteryTicket);
        this.bonusNumber = bonusNumber;
    }

    public LottoRank getRank(LotteryTicket input) {
        Set<Integer> inputValues = input.getValues();
        int matchCount = (int) inputValues.stream()
                .filter(getValues()::contains)
                .count();
        boolean bonusMatch = inputValues.contains(bonusNumber.getValue());
        return LottoRank.of(matchCount, bonusMatch);
    }

}
