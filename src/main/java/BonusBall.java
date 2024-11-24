import java.util.List;

public class BonusBall {
    private int value;

    public BonusBall(String numStr) {
        this(Integer.parseInt(numStr));
    }

    public BonusBall(int value) {
        if (value < Constants.MIN_LOTTO_NUMBER || value > Constants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    public boolean is(int num) {
        return this.value == num;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BonusBall) {
            return this.value == ((BonusBall) obj).value;
        }

       return false;
    }

    public boolean isOneOf(List<Integer> nums) {
        return nums.contains(this.value);
    }
}
