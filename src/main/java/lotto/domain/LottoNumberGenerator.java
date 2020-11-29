package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumbers.NUMBER_RANGE;

public class LottoNumberGenerator {

    private static final String DEFAULT_SEPARATOR = ",";
    private static final String BLANK = " ";
    private static final String DELETE_BLANK = "";
    public static final int NUMBER_MIN_RANGE = 1;
    public static final int NUMBER_MAX_RANGE = 45;

    private static final Map<Integer, LottoNumber> lottoNumbers = IntStream.range(NUMBER_MIN_RANGE, NUMBER_MAX_RANGE)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toMap(LottoNumber::getValue, lottoNumber -> lottoNumber));

    public Lottoes create(PurchaseAmount purchaseAmount) {
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

    public List<LottoNumber> create(String numbers) {
        validEmpty(numbers);
        return splitString(numbers).stream()
                .map(Integer::parseInt)
                .map(lottoNumbers::get)
                .collect(Collectors.toList());
    }

    private void validEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR);
        }
    }


    private List<String> splitString(String value) {
        return Arrays.asList(value.replace(BLANK, DELETE_BLANK).split(DEFAULT_SEPARATOR));
    }


}
