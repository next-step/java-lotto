package stringcalculator.splitter;

import stringcalculator.exception.NoSupportedSplitterException;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class SplitterManager {

    private Set<Splitter> splitters;

    private SplitterManager() {
        this(new CustomSplitter(), new CommaAndColonSplitter());
    }

    private SplitterManager(final Splitter... splitters) {
        this.splitters = new LinkedHashSet<>(Arrays.asList(splitters));
    }

    public static SplitterManager of() {
        return new SplitterManager();
    }

    public Splitter matchedSplitter(final String value) {
        return splitters.stream()
                .filter(splitter -> splitter.support(value))
                .findFirst()
                .orElseThrow(NoSupportedSplitterException::new);
    }
}
