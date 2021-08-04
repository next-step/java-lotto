package adder;

import java.util.List;

public interface TokenizeStrategy {

    List<String> split(Expression expression);

}
