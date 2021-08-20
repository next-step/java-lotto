package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ManualNumberStrategy implements PickNumberStrategy {

    List<Integer> lottoNumbers;

    @Override
    public List<Integer> makeLottoNumber() {
        lottoNumbers = new ArrayList<>();
        while (true) {
            try {
                String winningNumber = InputView.enterLottoNumber();
                convertStringArrayToIntArray(winningNumber.split(","));
                return lottoNumbers;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 로또 값을 입력하였습니다. 숫자만 입력 가능합니다.");
            }
        }
    }

    private void convertStringArrayToIntArray(String[] winningNumbers) {
        for (String number : winningNumbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }
    }
}
