import java.util.List;

public class Numbers {
    private List<SafeNumber> safeNumbers;

    public Numbers(List<SafeNumber> safeNumbers) {
        this.safeNumbers = safeNumbers;
    }

    public Integer getSum() {
        return this.safeNumbers.stream()
                .mapToInt(SafeNumber::getNumber)
                .sum();
    }
}
