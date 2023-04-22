package calculator.domain;

public class ClientResponse {

    private final String clientInput;

    private String[] cachedSplitInput;

    private static final int MINIMUM_EVEN_NUMBER = 2;

    private static final String EMPTY_MESSAGE = "값이 입력되지 않았습니다.";

    private static final String SEPARATOR = " ";

    private static final int TO_ROUND_UP = 1;

    public ClientResponse(String clientInput) {
        if (emptyTxt(clientInput)) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
        this.clientInput = clientInput;
    }

    private boolean emptyTxt(String source) {
        return source == null || source.isEmpty();
    }

    public String[] getNumbers() {
        return evenIndexedElements();
    }

    private String[] evenIndexedElements() {
        String[] numbers = new String[roundedUpNumber(splitInputSize())];

        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = splitInput()[index * 2];
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
        if (isNotCachedYet()) {
            this.cachedSplitInput = this.clientInput.split(SEPARATOR);
            return this.cachedSplitInput;
        }
        return this.cachedSplitInput;
    }

    private int splitInputSize() {
        if (isNotCachedYet()) {
            this.cachedSplitInput = splitInput();
            return cachedSplitInput.length;
        }
        return this.cachedSplitInput.length;
    }

    private boolean isNotCachedYet() {
        return this.cachedSplitInput == null;
    }
}
