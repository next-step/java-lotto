import java.util.List;

public class LottoNumber {
    protected static final int MIN_LOTTO_NUMBER = 1;
    protected static final int MAX_LOTTO_NUMBER = 45;

    private final int value;

    public LottoNumber(String str) {
        this(Integer.parseInt(str));
    }

    public LottoNumber(int value) {
        if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    public boolean is(int v) {
        return this.value == v;
    }

    public boolean isOneOf(List<LottoNumber> nums) {
        return nums.stream().anyMatch(n -> n.is(this.value));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            return this.value == ((LottoNumber) obj).value;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
