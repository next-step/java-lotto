package caculator;

import java.util.List;

public final class Util {

    private Util() {
    }

    public static List<String> split(final String input) {
        return List.of(input.split(" "));
    }
}
