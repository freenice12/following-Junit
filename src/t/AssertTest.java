package t;

public class AssertTest extends TestCase {

    public AssertTest(final String name) {
        super(name);
    }

    public static void main(final String[] args) throws Exception {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(AssertTest.class);
        final TestResult result = new TestResult();
        suite.run(result);
        TestCase.assertEquals("3 run, 0 failed", result.summary());
    }

    public void testAssertEquals() {
        final Object o = new Object();
        assertEquals(o, o);
    }

    public void testAssertNotEquals() {
        try {
            assertEquals(new Object(), new Object());
        } catch (final AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testAssertEqualsNull() {
        assertEquals(null, null);
    }
}
