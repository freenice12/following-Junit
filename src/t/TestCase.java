package t;

import java.lang.reflect.Method;

public class TestCase {

    private String name;

    public TestCase() {
    }

    public TestCase(final String name) {
        super();
        this.name = name;
    }

    public void run(final TestResult result) {
        result.testStarted();
        setUp();
        try {
            final Method method = this.getClass().getMethod(this.name);
            method.invoke(this);
        } catch (final Exception e) {
            result.testFailed();
        }
        tearDown();
    }

    public TestResult run() {
        final TestResult result = new TestResult();
        run(result);
        return result;
    }

    protected void tearDown() {

    }

    protected void setUp() {

    }

}
