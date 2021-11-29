package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.NotNumberException;

public class ManualLottoNumber implements CreatableLottoNumber {

    private static final String DELIMITER = ", ";

    private final String manualLottoNumber;

    public ManualLottoNumber(String manualLottoNumber) {
        this.manualLottoNumber = manualLottoNumber;
    }

    @Override
    public List<Integer> createLottoNumber() {
        try {
            return Arrays.stream(manualLottoNumber.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        }
    }

}
