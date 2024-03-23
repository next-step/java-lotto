package lottogame.domain;

public final class LottoNumber {

    private final int value;

    public LottoNumber(final int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        LottoNumber that = (LottoNumber) object;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {

        return String.valueOf(value);
    }
}
