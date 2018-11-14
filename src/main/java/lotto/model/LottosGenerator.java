package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface LottosGenerator {
    public List<Ticket> generate(Amount amount);
}
