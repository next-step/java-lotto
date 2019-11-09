package lotto.input;

import java.util.Optional;

public interface InputReader {
    Optional<Integer> readInt(String comment);
    String readLine(String comment);
}
