package t;

public class TestResult {

    private int runCount;
    private int failureCount;

    public void testStarted() {
        runCount += 1;
    }

    public String summary() {
        return String.format("%d run, %d failed", this.runCount,
                this.failureCount);
    }

    public void testFailed() {
        failureCount += 1;
    }

}
