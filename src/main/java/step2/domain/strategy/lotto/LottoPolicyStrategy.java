package step2.domain.strategy.lotto;

import step2.domain.model.Lotto.LottoNumber;
import step2.domain.model.Lotto.LottoNumbers;

import java.util.*;

public class LottoPolicyStrategy implements Strategy {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_RANDOM_RANGE_START = 1;
    private static final int LOTTO_RANDOM_RANGE_END = 37;
    private static final Random RANDOM = new Random();
    private static final String DELIMITER = ",";
    private static final String TRIM = " ";

    @Override
    public LottoNumbers createLottoNumbers() {
        Map<Integer, Integer> lottoNumberMap = new HashMap<>();
        List<LottoNumber> numbers = new ArrayList<>();

        while (numbers.size() < LOTTO_NUMBER_COUNT) {
            int random = RANDOM.nextInt(LOTTO_RANDOM_RANGE_END) + LOTTO_RANDOM_RANGE_START;
            if (isContainsNumber(lottoNumberMap, random)) {
                continue;
            }
            lottoNumberMap.put(random, lottoNumberMap.getOrDefault(random, 0) + 1);
            numbers.add(LottoNumber.from(random));
        }

        return new LottoNumbers(numbers);
    }

    private boolean isContainsNumber(Map<Integer, Integer> lottoNumberMap, int randomNumber) {
        return lottoNumberMap.containsKey(randomNumber);
    }

    @Override
    public LottoNumbers createWinningLottoNumber(String lastWinningNumbers) {
        String[] numbersArr = convertLastWinningNumberToStringArr(lastWinningNumbers);
        return new LottoNumbers(convertLastWinningNumberStringArrToListNumbers(numbersArr));
    }

    private String[] convertLastWinningNumberToStringArr(String lastWinningNumbers) {
        checkInputLastWinningNumbers(lastWinningNumbers);

        return lastWinningNumbers.replaceAll(TRIM, "")
                .split(DELIMITER);
    }

    private List<LottoNumber> convertLastWinningNumberStringArrToListNumbers(String[] numbersArr) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (String number : numbersArr) {
            try {
                numbers.add(LottoNumber.from(Integer.parseInt(number)));
            } catch (NumberFormatException numberFormatException) {
                throw new NumberFormatException("숫자이외의 값이 입력 되었습니다.");
            }
        }
        isSizeNotEqualToLottoNumberCount(numbers.size());
        return numbers;
    }

    private void checkInputLastWinningNumbers(String lastWinningNumbers) {
        if (lastWinningNumbers.length() < 0) {
            throw new IllegalStateException("입력값이 잘못되었습니다.");
        }
    }

    private void isSizeNotEqualToLottoNumberCount(int size) {
        if (size != LOTTO_NUMBER_COUNT) {
            throw new IllegalStateException(String.format("지정된 로또의 갯수가 아닙니다. 로또의 갯수는 %d", LOTTO_NUMBER_COUNT));
        }
    }
}
