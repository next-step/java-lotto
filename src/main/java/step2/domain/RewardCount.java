package step2.domain;

public class RewardCount {
    private final Reward reward;
    private int count;

    private RewardCount(final Reward reward, final int count) {
        this.reward = reward;
        this.count = count;
    }

    public static RewardCount of(final Reward reward, final int count) {
        return new RewardCount(reward, count);
    }

    public static RewardCount of(final Reward reward) {
        return of(reward, 0);
    }
    
    public void increase() {
        count += 1;
    }
    
    public boolean isMatch(final Reward reward) {
        return this.reward == reward;
    }
    
    public int getCount() {
        return count;
    }
}
