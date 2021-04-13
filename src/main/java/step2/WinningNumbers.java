package step2;

import step2.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final LottoNumberGenerator lottoNumberGenerator;
    private List<Integer> winningNumbers = new ArrayList<>();

    public WinningNumbers(LottoNumberGenerator lottoNumberGenerator){
        this.lottoNumberGenerator = lottoNumberGenerator;
        makeWinningNumbers();
    }

    private void makeWinningNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        winningNumbers = lottoNumberGenerator.generateNumbers();
        ValidationUtils.validationNumbers(winningNumbers);
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }
}
