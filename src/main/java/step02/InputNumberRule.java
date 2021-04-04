package step02;

import java.util.ArrayList;
import java.util.List;

import static step02.LottoConfig.SEPARATOR_NUMBER;

public class InputNumberRule extends NumberRule {
    List<Integer> inputNumber;

    public InputNumberRule(String inputNumber) throws Exception {
        this.inputNumber = splitNumber(inputNumber);
    }

    @Override
    public List<Integer> makeNumbers() {
        return inputNumber;
    }

    private List<Integer> splitNumber(String numbers) throws Exception {
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] stringNumbers = numbers.split(SEPARATOR_NUMBER);
        for (String number : stringNumbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }

        return lottoNumbers;
    }
}
