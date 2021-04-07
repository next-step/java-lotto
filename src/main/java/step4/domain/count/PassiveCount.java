package step4.domain.count;

public final class PassiveCount {

    private final int count;

    private PassiveCount(int count) {
        this.count = count;
    }

    public static final PassiveCount valueOf(int count) {
        return new PassiveCount(count);
    }
}
