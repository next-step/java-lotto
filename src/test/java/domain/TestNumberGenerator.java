package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static util.CollectionCast.*;

public class TestNumberGenerator implements NumberGenerator {

    private List<LottoNo> numbers;

    @Override
    public Map<Integer, LottoNo> getRandomNumber() {
        return changeListToMap(numbers);
    }

    public void setRandomNumber(List<LottoNo> numbers) {
        this.numbers = new ArrayList<>();
        this.numbers.addAll(numbers);
    }

}
