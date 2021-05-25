package step3.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import step3.constant.Rank;
import step3.util.StringUtils;

public final class LottoNumbers {

    private static final int MAX_SIZE = 6;
    private static final String CHECK_SIZE = "6개의 숫자까지만 담을 수 있습니다.";
    private static final String CHECK_EMPTY = "공백은 불가능 합니다.";
    private static final String CHECK_BONUS = "기존에 있던 수는 보너스 숫자가 될 수 없습니다.";

    private final Set<LottoNumber> lottoNumbers;
    private LottoNumber bonusNumber;

    private LottoNumbers(List<Integer> numbers) {
        validationSize(numbers);
        this.lottoNumbers = new TreeSet<>();
        numbers.stream()
            .forEach(number -> lottoNumbers.add(new LottoNumber(number)));
    }

    public LottoNumbers(List<Integer> numbers, Integer bonusNumber) {
        this(numbers);
        checkBonusValidation(bonusNumber);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public static LottoNumbers of(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    public static LottoNumbers of(String numbers) {
        List<Integer> numberList = stringToIntegerList(numbers);
        return new LottoNumbers(numberList);
    }

    public static LottoNumbers of(String numbers, String bounus) {
        List<Integer> numberList = stringToIntegerList(numbers);
        Integer bounusValue = StringUtils.parseInt(bounus);
        return new LottoNumbers(numberList, bounusValue);
    }

    public static List<Integer> stringToIntegerList(String numbers) {
        validationEmpty(numbers);
        numbers = numbers.replace(" ", "");
        return Arrays.stream(numbers.split(",")).map(StringUtils::parseInt)
            .collect(Collectors.toList());
    }

    public Rank getRankWithVictoryNumber(LottoNumbers victoryNumber) {
        int matchedCount = (int)lottoNumbers.stream()
            .filter(victoryNumber::contains).count();

        boolean hasBous = lottoNumbers.stream()
            .filter(victoryNumber::isMatchedBonus)
            .count() == 1;

        return Rank.findRankPriceBymatchedCount(matchedCount, hasBous);
    }

    public String getStatus() {
        List<String> temp = new ArrayList<>(Arrays.asList("["));
        lottoNumbers.stream()
            .forEach(lottoNumber -> temp.add(lottoNumber.getStatus()));
        temp.add("]");
        return String.join(" ", temp);
    }

    private boolean isAddAvailableInput(List<Integer> numbers) {
        return numbers.size() <= MAX_SIZE;
    }

    private boolean contains(LottoNumber compare) {
        return lottoNumbers.stream()
            .filter(lottoNumber -> lottoNumber.equals(compare)).count() == 1;
    }

    private boolean isMatchedBonus(LottoNumber compare) {
        return this.bonusNumber != null && this.bonusNumber.equals(compare);
    }

    private void checkBonusValidation(Integer bonusNumber) {
        boolean isInNumbers = lottoNumbers.stream()
            .filter(number -> number.equals(new LottoNumber(bonusNumber)))
            .count() == 1;

        if (isInNumbers) {
            throw new IllegalArgumentException(CHECK_BONUS);
        }
    }

    private void validationSize(List<Integer> numberList) {
        if (!isAddAvailableInput(numberList)) {
            throw new IllegalArgumentException(CHECK_SIZE);
        }
    }

    private static boolean validationEmpty(String numbers) {
        if (null == numbers || "".equals(numbers.trim())) {
            throw new IllegalArgumentException(CHECK_EMPTY);
        }
        return true;
    }

}
