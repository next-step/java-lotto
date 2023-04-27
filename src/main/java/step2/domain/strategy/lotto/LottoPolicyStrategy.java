package step2.domain.strategy.lotto;

import step2.domain.model.Lotto.LottoNumber;

import java.util.*;

public class LottoPolicyStrategy implements Strategy {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_RANDOM_RANGE_START = 1;
    private static final int LOTTO_RANDOM_RANGE_END = 37;
    private static final Random RANDOM = new Random();
    private static final String DELIMITER = ",";
    private static final String TRIM = " ";

    @Override
    public List<LottoNumber> createLottoNumber() {
        Map<Integer, Integer> lottoNumberMap = new HashMap<>();
        List<LottoNumber> numbers = new ArrayList<>();

        while (numbers.size() < LOTTO_NUMBER_COUNT) {
            int random = RANDOM.nextInt(LOTTO_RANDOM_RANGE_END)+LOTTO_RANDOM_RANGE_START;
            if (isContainsNumber(lottoNumberMap, random)) {
                continue;
            }
            lottoNumberMap.put(random, lottoNumberMap.getOrDefault(random, 0) + 1);
            numbers.add(LottoNumber.createLottoNumber(random));
        }
        return numbers;
    }

    private boolean isContainsNumber(Map<Integer, Integer> lottoNumberMap, int randomNumber) {
        return lottoNumberMap.containsKey(randomNumber);
    }

    @Override
    public List<LottoNumber> createWinningLotto(String lastWinningNumbers) {
        List<LottoNumber> numbers = new ArrayList<>();
        String[] numbersArr = lastWinningNumbers.replaceAll(TRIM, "")
                .split(DELIMITER);

        for (String number : numbersArr) {
            try {
                numbers.add(LottoNumber.createLottoNumber(Integer.parseInt(number)));
            } catch (NumberFormatException numberFormatException) {
                throw new NumberFormatException("숫자이외의 값이 입력 되었습니다.");
            }
        }

        isSizeNotEqualToLottoNumberCount(numbers.size());
        return numbers;
    }

    private void isSizeNotEqualToLottoNumberCount(int size) {
        if (size != LOTTO_NUMBER_COUNT) {
            throw new IllegalStateException("잘못된 형식의 문장입니다.");
        }
    }
}
