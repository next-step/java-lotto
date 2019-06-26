package lotto;


import java.util.List;

public interface LottoNumGenerator {
    public static final int MIN_INT = 1;
    public static final int MAX_INT = 45;
    public List<Integer> generate();
}
