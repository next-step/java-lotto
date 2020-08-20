package step2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Lottos implements Iterable<Lotto> {

  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = Collections.unmodifiableList(lottos);
  }

  public int count() {
    return lottos.size();
  }

  public static Lottos of(Lotto... lottos) {
    return new Lottos(Arrays.asList(lottos));
  }

  public static Lottos concat(Lottos a, Lottos b) {
    return new Lottos(Stream.concat(toStream(a), toStream(b)).collect(Collectors.toList()));
  }

  private static Stream<Lotto> toStream(Lottos lottos) {
    return StreamSupport.stream(lottos.spliterator(), false);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lottos lottos1 = (Lottos) o;
    return Objects.equals(lottos, lottos1.lottos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottos);
  }

  @Override
  public String toString() {
    return "Lottos{" + "lottos=" + lottos + '}';
  }

  @Override
  public Iterator<Lotto> iterator() {
    return new LottoIterator();
  }

  private class LottoIterator implements Iterator<Lotto> {

    int current = 0;

    @Override
    public boolean hasNext() {
      return current < lottos.size();
    }

    @Override
    public Lotto next() {
      return lottos.get(current++);
    }
  }
}
