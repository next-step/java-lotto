package step2.domain;

import java.util.function.Function;

public class Util {
    public static <T, R> Function<T, R> exceptionWrapper(Function<T, R> function) {
        return arg -> {
          try {
              return function.apply(arg);
          } catch (Exception e) {
              e.printStackTrace();
              return null;
          }
        };
    }
}
