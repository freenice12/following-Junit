package t;

import java.lang.reflect.Method;

public class TestCase extends Assert implements Test {

    private String name;

    public TestCase() {
    }

    public TestCase(final String name) {
        super();
        this.name = name;
    }

    @Override
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

    public static void assertEquals(final Object expected,
            final Object actual) {
        if (expected == null && actual == null)
            return;

        if (expected != null && expected.equals(actual))
            return;

        fail();
    }

    public static void fail() {
        throw new AssertionFailedError();
    }

}
