package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WinningLottoNumbers {
    private List<Integer> winningLottoNumbers;
    private int bonusNumber;

    public WinningLottoNumbers(String winningNumbers, int bonusNumber) {
        List<Integer> winningLottoNumbers = new ArrayList<>();

        if( new HashSet<>(winningLottoNumbers).size() !=6) {
            throw new IllegalArgumentException("로또 번호는 6개여야한다.");
        }
        for (String element : winningNumbers.split(",| ,")) {
            int number = Integer.valueOf(element);

            if(number>1 || number<45){
                throw new IllegalArgumentException("로또 번호는 1~45 까지 가능합니다.");
            }
            winningLottoNumbers.add(number);

        }
        this.winningLottoNumbers = winningLottoNumbers;

        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
