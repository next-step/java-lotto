package lotto.presentation.output;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottosOutputView {
    public void output(Lottos lottos) {
        lottos.getElements().stream()
                .map(Lotto::getElements)
        .map(this::toStrings)
        .map(this::toOutputFormat)
        .forEach(System.out::println);
    }

    private List<String> toStrings(List<Integer> elements) {
        return elements.stream().map(String::valueOf).collect(Collectors.toList());
    }

    private String toOutputFormat(List<String> elements) {
        return "[" + String.join(", ", elements) + "]";
    }
}
