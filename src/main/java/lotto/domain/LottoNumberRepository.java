package lotto.domain;

import util.ValidateUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class LottoNumberRepository {
    private static final int INITIAL_INDEX = 0;
    private static final int TOTAL_LENGTH = 6;
    private static final String VALID_INPUT_EMPTY_MESSAGE = "수동으로 구매할 번호를 입력해주세요";
    private static final String COMMA_SEPARATOR = ",";
    private static final String VALID_SEPARAOR_MESSAGE = "구분자 ,가 없습니다.";
    private static final String VALID_NO_NUMBER_MESSAGE = "수동으로 구매할 번호는 숫자를 입력하셔야합니다.";

    private final List<LottoNumber> lottoNumber = new ArrayList<>();
    private final List<Lotto> manualLottos = new ArrayList<>();

    public LottoNumberRepository() {
        for (int i = LottoNumber.MIN_LOTTO_NUMBER; i <= LottoNumber.MAX_LOTTO_NUMBER; i++) {
            lottoNumber.add(new LottoNumber(i));
        }
    }

    public void add(String manualLottoInput) {
        List<LottoNumber> numbers = of(manualLottoInput);
        manualLottos.add(new Lotto(numbers));
    }

    public static List<LottoNumber> of(String manualLottoInput) {
        validate(manualLottoInput);
        return Arrays.stream(manualLottoInput.split(COMMA_SEPARATOR))
                .map(input -> new LottoNumber(parseNumber(input)))
                .collect(toList());
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALID_NO_NUMBER_MESSAGE);
        }
    }

    private static void validate(String input) {
        validateEmpty(input);
        validateSeparator(input);
    }

    private static void validateEmpty(String input) {
        if (ValidateUtils.isEmpty(input)) {
            throw new IllegalArgumentException(VALID_INPUT_EMPTY_MESSAGE);
        }
    }

    private static void validateSeparator(String input) {
        if (!input.contains(COMMA_SEPARATOR)) {
            throw new IllegalArgumentException(VALID_SEPARAOR_MESSAGE);
        }
    }

    public List<LottoNumber> getAutoLottoNumbers() {
        List<LottoNumber> randomNumbers = getRandonNumbers();
        return randomNumbers.stream()
                .sorted(Comparator.comparing(LottoNumber::number))
                .collect(Collectors.toList());
    }

    private List<LottoNumber> getRandonNumbers() {
        Collections.shuffle(lottoNumber);
        return lottoNumber.subList(INITIAL_INDEX, TOTAL_LENGTH);
    }

    public List<Lotto> getManualLottos() {
        return Collections.unmodifiableList(manualLottos);
    }
}
