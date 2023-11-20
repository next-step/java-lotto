package step3.model;

import step3.enumeration.LottoRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinner {

    private final WinnerBoard winnerBoard;
    private final List<Lotto> lottos;
    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public LottoWinner(List<Lotto> lottos, String winNumber, WinnerBoard winnerBoard, int bonusNumber) {
        this.winnerBoard = winnerBoard;
        this.lottos = lottos;
        this.winNumbers = splitWinNumberString(winNumber);

        validateBonusNumber(winNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<String, Integer> board : this.winnerBoard.winnerBoard.entrySet()) {
            if (board.getValue() > 0) totalPrice += LottoRank.getPriceByName(board.getKey());
        }

        return totalPrice;
    }

    public WinnerBoard getWinnerNumberMatchCount() {
        for (Lotto lotto : this.lottos) {
            String rankName = lotto.getNumbers().getLottoRank(this.winNumbers, this.bonusNumber);
            this.winnerBoard.winnerBoard.put(rankName, winnerBoard.winnerBoard.get(rankName) + 1);
        }

        return this.winnerBoard;
    }

    public Double getRating(int payPrice) {
        int totalPrice = getTotalPrice();
        return Math.floor(totalPrice * 100.0 / payPrice) / 100;
    }

    private List<Integer> splitWinNumberString(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(","))
                .map(Integer::parseInt)
                .filter(e -> !new LottoNumber().isOverMaxNumber(e))
                .collect(Collectors.toList());

    }

    private void validateBonusNumber(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호에 포함된 보너스 번호 입니다.");
        }
    }
}
