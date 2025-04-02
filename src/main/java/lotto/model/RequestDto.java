package lotto.model;

import java.util.Collections;
import java.util.List;

public class RequestDto {
    private final List<Integer> userInputNumbers;

    public RequestDto() {
        this(Collections.emptyList());
    }
    public RequestDto(List<Integer> userInputNumbers) {
        this.userInputNumbers = userInputNumbers;
    }

    public List<Integer> getUserInputNumbers() {
        return userInputNumbers;
    }
}
