package lotto.domain;

import lotto.dto.WinningLotteryNumbersRequest;

import java.util.List;

public class WinningLotteryTicket {

    private final Lottery lottery;

    private final LotteryNumber bonusLotteryNumber;

    public WinningLotteryTicket(List<Integer> numberList, int bonusNumber) {
        validateBonusNumberIsDuplicateInLottery(numberList, bonusNumber);
        lottery = new Lottery(numberList);
        bonusLotteryNumber = new LotteryNumber(bonusNumber);
    }

    public static WinningLotteryTicket ofRequest(WinningLotteryNumbersRequest winningLotteryNumbersRequest) {
        return new WinningLotteryTicket(winningLotteryNumbersRequest.getLastWinningLotteryNumbers(),
                winningLotteryNumbersRequest.getBonusNumber());
    }

    private void validateBonusNumberIsDuplicateInLottery(List<Integer> numberList, int bonusNumber) {
        if (numberList.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또번호로 채택퇸 번호는 보너스 번호로 사용할 수 없습니다.");
        }
    }

    public LotteryPrize match(Lottery lotteryFormLotteryTicket) {
        int matchingCount = lotteryFormLotteryTicket.getMatchCount(lottery);
        boolean isMatchingBonus = lotteryFormLotteryTicket.isMatch(bonusLotteryNumber);
        return LotteryPrize.valueOf(matchingCount, isMatchingBonus);
    }

}
