package calculator.domain;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientResponse {

    private static final int MINIMUM_EVEN_NUMBER = 2;

    private static final String EMPTY_MESSAGE = "값이 입력되지 않았습니다.";

    private static final String SEPARATOR = " ";

    private static final int TO_ROUND_UP = 1;

    private final String clientInput;

    private String[] cachedSplitInput;

    public ClientResponse(String clientInput) {
        if (emptyTxt(clientInput)) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
        this.clientInput = clientInput;
    }

    private boolean emptyTxt(String source) {
        return source == null || source.isEmpty();
    }

    public List<Integer> getNumbers() {
        return evenIndexedElements();
    }

    public List<String> getSymbols() {
        return oddIndexedElements();
    }

    public List<String> oddIndexedElements() {
        List<String> operators = new ArrayList<>();

        for (int index = 0; index < roundedDownNumber(splitInputSize()); index++) {
            operators.add(splitInput()[index * 2 + 1]);
        }

        return operators;
    }

    private List<Integer> evenIndexedElements() {
        List<Integer> numbers = new ArrayList<>();

        for (int index = 0; index < roundedUpNumber(splitInputSize()); index++) {
            numbers.add(parseInt(splitInput()[index * 2]));
        }

        return numbers;
    }

    private int roundedDownNumber(int number) {
        return number / MINIMUM_EVEN_NUMBER;
    }

    private int roundedUpNumber(int number) {
        return (number / MINIMUM_EVEN_NUMBER) + TO_ROUND_UP;
    }

    private String[] splitInput() {
        if (notCachedYet()) {
            this.cachedSplitInput = this.clientInput.split(SEPARATOR);
            return this.cachedSplitInput;
        }
        return this.cachedSplitInput;
    }

    private int splitInputSize() {
        if (notCachedYet()) {
            this.cachedSplitInput = splitInput();
            return cachedSplitInput.length;
        }
        return this.cachedSplitInput.length;
    }

    private boolean notCachedYet() {
        return this.cachedSplitInput == null;
    }

    @Override
    public String toString() {
        return "ClientResponse{" +
                "clientInput='" + clientInput + '\'' +
                ", cachedSplitInput=" + Arrays.toString(cachedSplitInput) +
                '}';
    }
}
