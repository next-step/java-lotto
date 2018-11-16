package domain;

import java.util.ArrayList;
import java.util.List;

public class TestNumberGenerator implements NumberGenerator {

    private List<LottoNo> numbers;

    @Override
    public List<LottoNo> getRandomNumber() {
        return numbers;
    }

    public void setRandomNumber(List<LottoNo> numbers) {
        this.numbers = new ArrayList<>();
        this.numbers.addAll(numbers);
    }

}
