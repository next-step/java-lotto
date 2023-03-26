package lotto.domain;

import lotto.view.InputView;

import java.util.List;

public class WinningNumber {
    public List<Integer> winningNums;
    public int bonusNum;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber){
        checkWinningNumbers(bonusNumber, winningNumbers);
        this.winningNums = winningNumbers;
        this.bonusNum = bonusNumber;
    }

    public WinningNumber(InputView inputView) {
        List<Integer> winningNumbers = inputView.inputWinningNum();
        int bonusNumber = inputView.inputBonusNum();
        checkWinningNumbers(bonusNumber, winningNumbers);
        this.winningNums = winningNumbers;
        this.bonusNum = bonusNumber;
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public int getBonusNums() {
        return bonusNum;
    }

    public void checkWinningNumbers(int inputBonus, List<Integer> inputWinningNums) {
        checkBonusNum(inputBonus, inputWinningNums);
        checkWinningsNums(inputWinningNums);
    }

    //보너스 번호 체크
    public void checkBonusNum(int inputBonus, List<Integer> inputWinningNums){
        if(inputWinningNums.contains(inputBonus)) {
            throw new IllegalArgumentException("당첨번호와 중복된 번호를 사용할 수 없습니다");
        }
        if(inputBonus > 45 || inputBonus < 1){
            throw new IllegalArgumentException("1~45 사이의 번호가 아닙니다.");
        }
    }

    //당첨번호 체크시 LottoTicket의 checkLotto로직 사용
    public void checkWinningsNums(List<Integer> inputWinningNums){
        LottoTicket.checkLotto(inputWinningNums);
    }
}