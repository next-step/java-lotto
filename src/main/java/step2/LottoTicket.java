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
        value = value.replaceAll(REGEX_THE_BRACKETS_AND_SPACE, EMPTY_STRING);
        lottoNumbers.addAll(Arrays.asList(value.split(",")));
        validate();
    }

    private void validate() {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> numbers() {
        return lottoNumbers;
    }
}
