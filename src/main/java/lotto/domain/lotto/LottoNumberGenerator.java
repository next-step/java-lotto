package lotto.domain.lotto;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumberGenerator {
    private static final List<LottoNumber> numbers = createWholeLottoNumbers();
    private final List<LottoNumbers> lottoNumbers;

    public LottoNumberGenerator(Price price, List<String> manualNumberStrings) {
        this.lottoNumbers = createLottoNumbers(price, manualNumberStrings);
    }

    private List<LottoNumbers> createLottoNumbers(Price price, List<String> manualNumberStrings) {
        List<LottoNumbers> manualLottoNumbers = createManualLottoNumbers(manualNumberStrings);
        List<LottoNumbers> autoLottoNumbers = createAutoLottoNumbers(price, manualLottoNumbers);

        List<LottoNumbers> allLottoNumbers = new ArrayList<>();
        allLottoNumbers.addAll(manualLottoNumbers);
        allLottoNumbers.addAll(autoLottoNumbers);

        return allLottoNumbers;
    }

    private List<LottoNumbers> createManualLottoNumbers(List<String> manualNumberStrings) {
        return manualNumberStrings.stream()
                .map(StringUtil::splitAndToIntegerList)
                .map(LottoNumbers::manualLottoNumber)
                .collect(Collectors.toList());
    }

    private List<LottoNumbers> createAutoLottoNumbers(Price price, List<LottoNumbers> manualLottoNumbers) {
        int autoLottoCount = price.getLottoCount() - manualLottoNumbers.size();

        return IntStream.range(0, autoLottoCount)
                .mapToObj(i -> LottoNumbers.autoLottoNumber(getAutoLottoNumbers()))
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> createWholeLottoNumbers() {
        int initialValue = LottoNumber.MIN_VALUE;
        AtomicInteger value = new AtomicInteger(initialValue);

        return IntStream.generate(value::getAndIncrement)
                .limit(LottoNumber.MAX_VALUE)
                .boxed()
                .map(LottoNumber::new)
                .collect(toList());
    }

    public List<LottoNumber> getAutoLottoNumbers() {
        Collections.shuffle(numbers);

        return numbers.subList(0, LottoNumbers.LOTTO_SIZE)
                .stream()
                .sorted()
                .collect(toList());
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }
}
