package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasicLottoMachine implements LottoMachine {

    private static String DELIMITER = ", ";
    private NumberGenerator numberGenerator;

    public BasicLottoMachine(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public Lotto issue() {
        final List<Integer> numbers = numberGenerator.generate();
        return new Lotto(numbers);
    }

    @Override
    public Lotto issue(String directLottoNumber) {
        final String[] directLottoNumberUnits = directLottoNumber.split(DELIMITER);
        final List<Integer> directLottoNumbers = new ArrayList<>();

        for (String directLottoNumberUnit : directLottoNumberUnits) {
            directLottoNumbers.add(Integer.parseInt(directLottoNumberUnit));
        }

        return new Lotto(directLottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicLottoMachine that = (BasicLottoMachine) o;
        return Objects.equals(numberGenerator, that.numberGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberGenerator);
    }
}
