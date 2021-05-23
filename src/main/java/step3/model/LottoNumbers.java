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

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = new TreeSet<>();
    }

    public LottoNumbers(List<Integer> numbers) {
        validationSize(numbers);
        this.lottoNumbers = new TreeSet<>();
        numbers.stream().forEach(number -> lottoNumbers.add(new LottoNumber(number)));
    }

    public static LottoNumbers of(String numbers) {
        validationEmpty(numbers);
        List<Integer> numberList = stringToIntegerList(numbers);
        return new LottoNumbers(numberList);
    }

    private void validationSize(List<Integer> numberList) {
        if (!isAddAvailableInput(numberList)) {
            throw new IllegalArgumentException(CHECK_SIZE);
        }
    }

    public static List<Integer> stringToIntegerList(String numbers) {
        numbers = numbers.replace(" ", "");
        return Arrays.stream(numbers.split(",")).map(StringUtils::parseInt).collect(Collectors.toList());
    }

    private static boolean validationEmpty(String numbers) {
        if (null == numbers || "".equals(numbers.trim())) {
            throw new IllegalArgumentException(CHECK_EMPTY);
        }
        return true;
    }

    public Rank getRankWithVictoryNumber(LottoNumbers victoryNumber) {
        int matchedCount = (int) lottoNumbers.stream().filter(victoryNumber::contains).count();

        return Rank.findRankPriceBymatchedCount(matchedCount);
    }

    @Override
    public String toString() {
        List<String> temp = new ArrayList<>(Arrays.asList("["));
        lottoNumbers.stream().forEach(lottoNumber -> temp.add(lottoNumber.toString()));
        temp.add("]");
        return String.join(" ", temp);
    }

    private boolean isAddAvailableInput(List<Integer> numbers) {
        return numbers.size() <= MAX_SIZE;
    }

    private boolean contains(LottoNumber compare) {
        return lottoNumbers.stream().filter(lottoNumber -> lottoNumber.equals(compare)).count() == 1;
    }

}
