import java.util.List;

public interface LottoGenerator {
    List<Integer> generate();
    String getName();

    int getPrice();
}
