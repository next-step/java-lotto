package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ManualNumberStrategy implements PickNumberStrategy {

    List<Integer> lottoNumbers = new ArrayList<>();


    @Override
    public List<Integer> makeLottoNumber() {
        String winningNumber = InputView.enterLottoNumber();
        convertStringArrayToIntArray(winningNumber.split(","));
        return lottoNumbers;
    }

    private void convertStringArrayToIntArray(String[] winningNumbers) {
        for (String number : winningNumbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }
    }
}
