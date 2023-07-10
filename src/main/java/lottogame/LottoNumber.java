package lottogame;

public final class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(final String value) {
        validateNull(value);
        validateBlank(value);
        int number = Integer.parseInt(value.trim());
        validate(number);
        this.lottoNumber = number;

    }

    private void validateBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다");
        }
    }

    private void validateNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다");
        }
    }

    private void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("1이상 45이하의 숫자여야합니다");
        }
    }
}
