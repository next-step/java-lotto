package lotto.domain;

import lotto.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int ZERO_INIT = 0;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 46;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int REMOVE_INDEX = 0;

    public LottoMachine() {
    }

    List<Lotto> autoCreateLotto(int autoQuantity) {
        int count = ZERO_INIT;
        List<Lotto> lottos = new ArrayList<>();
        while(count < autoQuantity) {
            lottos.add(createLotto(generateLottoNumber()));
            count++;
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumber() {
        List<Integer> baseNumbers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).forEach(baseNumbers::add);
        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            Collections.shuffle(baseNumbers);
            numbers.add(baseNumbers.remove(REMOVE_INDEX));
        }
        Collections.sort(numbers);

        return numbers;
    }

    private List<Lotto> createManualLotto(List<String> manualNumbers) {
        List<Lotto> manualLottos = new ArrayList<>();
        if(manualNumbers == null || manualNumbers.size() == 0) {
            return manualLottos;
        }

        for (String manualNumber : manualNumbers) {
            Lotto lotto = createLotto(manualNumberToLottoNumbers(manualNumber));
            manualLottos.add(lotto);
        }

        return manualLottos;
    }

    private List<Integer> manualNumberToLottoNumbers(String manualNumber) {
        String[] splitStr = Utils.stringSplitWithDelimiter(manualNumber, ",");
        return Arrays.stream(splitStr)
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Lotto> getAllLotto(int autoQuantity, List<String> manualNumbers) {
        List<Lotto> totalLotto = new ArrayList<>();
        totalLotto.addAll(autoCreateLotto(autoQuantity));
        totalLotto.addAll(createManualLotto(manualNumbers));

        return totalLotto;
    }

    private Lotto createLotto(List<Integer> numbers) {
        LottoNumbers lottoNumbers = new LottoNumbers(numbers.toArray(new Integer[0]));
        return new Lotto(lottoNumbers);
    }
}
