package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTicket {
    public static final String REGEX_THE_BRACKETS_AND_SPACE = "[\\[\\] ]";
    public static final String EMPTY_STRING = "";
    private List<String> lottoNumbers;

    public LottoTicket(String value) {
        lottoNumbers = new ArrayList<>();
        splitAndValidate(value);
    }

    private void splitAndValidate(String value) {
        split(value);
        validate();
    }

    private void split(String value) {
        value = value.replaceAll(REGEX_THE_BRACKETS_AND_SPACE, EMPTY_STRING);
        lottoNumbers.addAll(Arrays.asList(value.split(",")));
    }

    private void validate() {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (lottoNumbers
                .stream()
                .anyMatch(member -> Integer.parseInt(member) > 45 || Integer.parseInt(member) < 0)) {
            throw new IllegalArgumentException();
        }

    }

    public int matchedNumber(String[] expected) {
        return (int) lottoNumbers
                .stream()
                .filter(member -> Arrays
                        .asList(expected)
                        .contains(member))
                .count();
    }

    public List<String> numbers() {
        return lottoNumbers;
    }
}
