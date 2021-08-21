package step1;

import java.util.List;

public interface Parser<T> {

  List<NationalNumber> parse(T t);

}
