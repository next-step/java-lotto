package lotto.model;

import java.util.List;

public interface LottosGenerator {
    public List<Ticket> generate(Amount amount);
}
