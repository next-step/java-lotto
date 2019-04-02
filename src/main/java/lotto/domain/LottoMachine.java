package lotto.domain;

import lotto.Utils;

import java.util.*;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int ZERO_INIT = 0;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 46;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int REMOVE_INDEX = 0;
    private final int autoQuantity;
    private final List<String> manualNumbers;

    public LottoMachine(int quantity, int manualQuantity, List<String> manualNumbers) {
        this.autoQuantity = quantity - manualQuantity;
        this.manualNumbers = manualNumbers;
    }

    public List<Lotto> autoCreateLotto() {
        int count = ZERO_INIT;
        List<Lotto> lottos = new ArrayList<>();
        while(count < autoQuantity) {
            lottos.add(new Lotto(new LottoNumbers(generateLottoNumber().toArray(new Integer[0]))));
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

    private List<Lotto> createManualLotto() {
        List<Lotto> manualLottos = new ArrayList<>();
        LottoNumberGenerator lottoNumberGenerator = LottoNumberGenerator.getInstance();
        for (String manualNumber : manualNumbers) {
            String[] splitStr = Utils.stringSplitWithDelimiter(manualNumber, ",");
            LottoNumber[] numbers = Arrays.stream(splitStr)
                    .map(Integer::valueOf)
                    .map(lottoNumberGenerator::valueOf)
                    .toArray(LottoNumber[]::new);

            Set<LottoNumber> lottoNumbers = new HashSet<>(Arrays.asList(numbers));
            manualLottos.add(new Lotto(new LottoNumbers(lottoNumbers)));
        }

        return manualLottos;
    }

    public List<Lotto> getAllLotto() {
        List<Lotto> totalLotto = new ArrayList<>();
        totalLotto.addAll(autoCreateLotto());
        totalLotto.addAll(createManualLotto());

        return totalLotto;
    }
}
