package domain;

import java.util.List;

import static domain.Lotto.convertLottoNumberList;
import static domain.LottoGenerator.DRAW_NUMBER_COUNT;

public class WinningNumbers {
    private List<LottoNumber> winningNumberList;
    private BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumberList, int bonusNumber) {
        if (winningNumberList == null || winningNumberList.isEmpty()) {
            throw new IllegalArgumentException("winningNumberList는 null이거나 비어있을 수 없습니다.");
        }

        if (winningNumberList.size() != DRAW_NUMBER_COUNT) {
            throw new IllegalArgumentException("winningNumberList의 사이즈가 잘못되었습니다. winningNumberList.size() : " + winningNumberList.size());
        }


        this.winningNumberList = convertLottoNumberList(winningNumberList);
        this.bonusNumber = new BonusNumber(bonusNumber, winningNumberList);
    }

    public boolean isMatch(LottoNumber lottoNumber){
        return winningNumberList.contains(lottoNumber);
    }

    public BonusNumber getBonusNumber(){
        return this.bonusNumber;
    }
}
