package lotto;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EarningResultMessage {

    private EarningResultMessage() {
    }

    private static final Map<Object, Object> valueIndex = Stream.of(new Object[][]{{-1, "손해"}, {1, "이득"}, {0, "본전"}})
            .collect(Collectors.collectingAndThen(
                    Collectors.toMap(data -> data[0], data -> data[1]),
                    Collections::<Object, Object>unmodifiableMap));

    public static String lookupByValue(int value) {
        return (String) valueIndex.get(value);
    }
}
