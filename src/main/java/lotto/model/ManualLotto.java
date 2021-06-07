package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class ManualLotto {
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    public List<Lotto> createLottos(int quantity, List<String> manualNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(createLottoNumbers(manualNumbers.get(i))));
        }
        return lottos;
    }

    private List<Integer> createLottoNumbers(String manualNumbers) {
        String[] splitManualNumbers = splitBySeparator(manualNumbers);
        List<Integer> lottoNumbers = addLottoNumbers(splitManualNumbers);
        return lottoNumbers;
    }

    private String[] splitBySeparator(String manualNumbers) {
        String separator = ", ";
        return manualNumbers.split(separator);
    }

    private List<Integer> addLottoNumbers(String[] manualNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_LOTTO_NUMBERS; i++) {
            lottoNumbers.add(convertToInt(manualNumbers[i]));
        }
        return lottoNumbers;
    }

    private int convertToInt(String number) {
        return Integer.parseInt(number);
    }
}
