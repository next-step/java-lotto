package step2.domain;

import java.util.Set;

@FunctionalInterface
public interface NumberProvider {

    Set<String> getNumbers(Integer count);
}
