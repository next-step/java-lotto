package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PickedLottoNumbers {

    private final List<Integer> pickedNumber;

    public PickedLottoNumbers(List<Integer> numbers) {
        List<Integer> integers = new ArrayList<>(numbers);
        Collections.sort(integers);
        this.pickedNumber = integers;
    }

    public int match(WinningNumbers winningNumbers) {
        return (int) pickedNumber.stream().filter(winningNumbers::confirm).count();
    }

    public boolean contains(int number) {
        return pickedNumber.contains(number);
    }

    public List<Integer> get() {
        return this.pickedNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PickedLottoNumbers that = (PickedLottoNumbers) o;
        return Objects.equals(pickedNumber, that.pickedNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pickedNumber);
    }
}
