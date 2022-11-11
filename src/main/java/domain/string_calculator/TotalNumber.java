package domain.string_calculator;

public class TotalNumber {
    private long total;

    public TotalNumber(Number number) {
        total = number.getNumber();
    }

    public void add(Number number) {
        total += number.getNumber();
    }

    public void subtract(Number number) {
        total -= number.getNumber();
    }

    public void divide(Number number) {
        total /= number.getNumber();
    }

    public void multiply(Number number) {
        total *= number.getNumber();
    }

    public long getTotal() {
        return total;
    }
}
