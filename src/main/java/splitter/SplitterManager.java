package splitter;

import java.util.Arrays;
import java.util.List;

public class SplitterManager {

    private List<Splitter> splitters;

    private SplitterManager() {
        this(new CustomSplitter(), new CommaAndColonSplitter());
    }

    private SplitterManager(final Splitter... splitters) {
        this.splitters = Arrays.asList(splitters);
    }

    public static SplitterManager of() {
        return new SplitterManager();
    }

    public Splitter matchedSplitter(final String value) {
        return splitters.stream()
                .filter(splitter -> splitter.support(value))
                .findFirst()
                .orElse(new CommaAndColonSplitter());
    }
}
