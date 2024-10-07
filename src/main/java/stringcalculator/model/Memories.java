package stringcalculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Memories {
    private final List<Memory> memories;

    public Memories(final Memory... memories) {
        this.memories = convertMemories(memories);
    }

    private List<Memory> convertMemories(Memory... memories) {
        return Arrays.stream(memories)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memories memories1 = (Memories) o;
        return Objects.equals(memories, memories1.memories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memories);
    }
}
