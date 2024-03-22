package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(String input) {
        validNull(input);
        splitNumbers(input);
        validNumberCount();
    }

    public LottoNumbers(List<LottoNumber> nums) {
        lottoNumbers.addAll(nums);
    }

    public static LottoNumbers fromIntegerList(List<Integer> numbersInput) {
        List<LottoNumber> nums = numbersInput.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(nums);
    }

    private void validNull(String nums) {
        if (nums == null) {
            throw new IllegalArgumentException("당첨 번호는 null이면 안됩니다.");
        }
    }

    private void splitNumbers(String numbers) {
        String[] splitArray = numbers.split(", ");
        for (String num : splitArray) {
            insertNumbers(num);
        }
    }

    private void insertNumbers(String number) {
        lottoNumbers.add(new LottoNumber(number));
    }

    private void validNumberCount() {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 형식과 맞는 숫자 개수를 입력하세요.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int matchedNumbersCount(LottoNumbers winNumbers) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> winNumbers.matchedNumber(lottoNumber.getNumber()))
                .count();
    }

    public boolean matchedNumber(int number) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.matchedNumber(number));
    }

    public String getLottoNumbersAsString() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
