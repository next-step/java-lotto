package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Papers {
    private static final String PAPER
    private List<Paper> papers;

    public Papers(Integer gameCount) {
        papers = IntStream.range(0, gameCount)
                          .mapToObj(value -> new Paper())
                          .collect(Collectors.toList());
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public Integer getPapersCount() {
        return papers.size();
    }

    public String getPaperNumbersToString() {
        return papers.stream().map(Objects::toString).collect(Collectors.joining("\n"));
    }

}
