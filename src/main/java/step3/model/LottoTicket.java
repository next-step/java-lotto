package step3.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final String REGEX_THE_BRACKETS_AND_SPACE = "[\\[\\] ]";
    public static final String EMPTY_STRING = "";
    public static final String STRING_DELIMITER = ",";
    private List<Integer> lottoNumbers;

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
        lottoNumbers.addAll(convertStringArrayIntoIntegerArray(value));
    }

    private List<Integer> convertStringArrayIntoIntegerArray(String value) {
        return Arrays.stream(value.split(STRING_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate() {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (lottoNumbers
                .stream()
                .anyMatch(member -> member > 45 || member < 0)) {
            throw new IllegalArgumentException();
        }

    }

    public int matchedNumber(String[] expected) {
        return (int) lottoNumbers
                .stream()
                .filter(member -> Arrays
                        .asList(expected)
                        .contains(String.valueOf(member))
                )
                .count();
    }

    public List<Integer> numbers() {
        return lottoNumbers;
    }

    public String printListMemberWithTemplate() {
        return lottoNumbers.toString();
    }

    public boolean isBonusBallIncluded(int ballNumber) {
        if (lottoNumbers.contains(ballNumber)) {
            return true;
        }
        return false;
    }
}
