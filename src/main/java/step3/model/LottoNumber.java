package step3.model;

public final class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String NOT_IN_RANGE = "1~45까지의 숫자를 입력하세요";

    private int number;

    public LottoNumber(final int number) {
        validation(number);
        this.number = number;
    }

    public int number() {
        return number;
    }

    private void validation(int number) {
        if (!isAvailableRange(number)) {
            throw new IllegalArgumentException(NOT_IN_RANGE);
        }
    }

    private boolean isAvailableRange(int number) {
        return (number >= MIN_NUMBER) && (number <= MAX_NUMBER);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + number;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LottoNumber other = (LottoNumber)obj;
        if (number != other.number)
            return false;
        return true;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return (number > other.number) ? 1 : -1;
    }

}
