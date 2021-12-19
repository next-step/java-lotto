package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoNumberMachine {

    private static final int LOTTO_NUMBERS_COUNT = 6;

    private static final List<Number> LOTTO_NUMBER_SOURCE = new ArrayList<Number>() {{
        addAll(Arrays.asList(
                Number.ONE, Number.TWO, Number.THREE, Number.FOUR, Number.FIVE,
                Number.SIX, Number.SEVEN, Number.EIGHT, Number.NINE, Number.TEN,
                Number.ELEVEN, Number.TWELVE, Number.THIRTEEN, Number.FOURTEEN, Number.FIFTEEN,
                Number.SIXTEEN, Number.SEVENTEEN, Number.EIGHTEEN, Number.NINETEEN, Number.TWENTY,
                Number.TWENTY_ONE, Number.TWENTY_TWO, Number.TWENTY_THREE, Number.TWENTY_FOUR, Number.TWENTY_FIVE,
                Number.TWENTY_SIX, Number.TWENTY_SEVEN, Number.TWENTY_EIGHT, Number.TWENTY_NINE, Number.THIRTY,
                Number.THIRTY_ONE, Number.THIRTY_TWO, Number.THIRTY_THREE, Number.THIRTY_FOUR, Number.THIRTY_FIVE,
                Number.THIRTY_SIX, Number.THIRTY_SEVEN, Number.THIRTY_EIGHT, Number.THIRTY_NINE, Number.FORTY,
                Number.FORTY_ONE, Number.FORTY_TWO, Number.FORTY_THREE, Number.FORTY_FOUR, Number.FORTY_FIVE
        ));
    }};

    public List<Number> lottoNumbers() {
        List<Number> numbers = new ArrayList<>();
        Collections.shuffle(LOTTO_NUMBER_SOURCE);

        for(int i = 0; i < LOTTO_NUMBERS_COUNT; i++) {
            numbers.add(LOTTO_NUMBER_SOURCE.get(i));
        }

        Collections.sort(numbers);
        return numbers;
    }

}
