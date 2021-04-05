package step02;

import java.util.ArrayList;
import java.util.List;

import static step02.LottoConfig.*;

public class InputNumberRule extends NumberRule {
    List<Integer> inputNumber;

    public InputNumberRule(String inputNumber) {
        this.inputNumber = splitNumber(inputNumber);
    }

    @Override
    public List<Integer> makeNumbers() {
        return inputNumber;
    }

    private List<Integer> splitNumber(String numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] stringNumbers = numbers
                .replace(BLANK, NO_BLANK)
                .split(REGEX);
        for (String number : stringNumbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }

        return lottoNumbers;
    }
}
