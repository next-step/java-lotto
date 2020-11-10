import java.util.List;

public class Splitters {
    private final List<String> splitters;

    public Splitters(List<String> splitters) {
        this.splitters = splitters;
    }

    public String getRegex() {
        return String.join("|", splitters);
    }
}
