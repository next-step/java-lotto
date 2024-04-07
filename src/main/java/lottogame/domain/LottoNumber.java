package lottogame.domain;

public final class LottoNumber {

    private final Number value;


    public LottoNumber(final Number value) {
        this.value = value;
    }

    public int getLottoNumber() {
        return value.intValue();
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
        return value.intValue() == that.value.intValue();
    }

    @Override
    public int hashCode() {
        return value.intValue();
    }
}
