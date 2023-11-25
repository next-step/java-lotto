package lotto.common;

import lotto.domain.Lotto;

import java.util.List;


public class GeneratorFactory {

    public static List<Lotto> generate(Object object) {
        if (List.class.isAssignableFrom(object.getClass())) {
            return ManualGenerator.generate((List<String>) object);
        }
        return AutoGenerator.generateByLottoCount((Integer) object);
    }
}
