package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.NUMBER_MAX_RANGE;
import static lotto.domain.LottoNumber.NUMBER_MIN_RANGE;
import static lotto.domain.LottoNumbers.NUMBER_RANGE;

public class LottoNumberGenerator {

    private static final String DEFAULT_SEPARATOR = ",";
    private static final String BLANK = " ";
    private static final String DELETE_BLANK = "";

    private static final Map<Integer, LottoNumber> lottoNumbers = IntStream.range(NUMBER_MIN_RANGE, NUMBER_MAX_RANGE)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toMap(LottoNumber::getValue, lottoNumber -> lottoNumber));

    public Lottoes create(int amount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        return new Lottoes(getLottoNumbers(purchaseAmount.getLottoCount()));
    }

    private List<LottoNumbers> getLottoNumbers(int lottoCount) {

        List<LottoNumber> numbers = new ArrayList<>(lottoNumbers.values());
        List<LottoNumbers> lottoes = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Collections.shuffle(numbers);

            List<Integer> lotto = numbers.stream()
                    .map(LottoNumber::getValue)
                    .limit(NUMBER_RANGE)
                    .sorted()
                    .collect(Collectors.toList());

            lottoes.add(new LottoNumbers(getCachedLottoNumbers(lotto)));
        }

        return lottoes;
    }

    private List<LottoNumber> getCachedLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(lottoNumbers::get)
                .collect(Collectors.toList());
    }

    public LottoNumbers create(String numbers) {
        List<LottoNumber> lotto = splitString(numbers).stream()
                .map(Integer::parseInt)
                .map(lottoNumbers::get)
                .collect(Collectors.toList());
        return new LottoNumbers(lotto);
    }

    private List<String> splitString(String value) {
        validEmpty(value);
        return Arrays.asList(value.replace(BLANK, DELETE_BLANK).split(DEFAULT_SEPARATOR));
    }


    private void validEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR);
        }
    }


}
