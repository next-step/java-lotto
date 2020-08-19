package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTicket {
    private List<String> lottoNumbers;

    public LottoTicket(String value) {
        lottoNumbers = new ArrayList<>();
        splitAndValidate(value);
    }

    private void splitAndValidate(String value) {
        value = value.replaceAll("[\\[\\] ]","");
        lottoNumbers.addAll(Arrays.asList(value.split(",")));
    }

    public List<String> numbers() {
        return lottoNumbers;
    }
}
