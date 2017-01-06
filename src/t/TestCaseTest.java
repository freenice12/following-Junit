package t;

public class TestCaseTest extends TestCase {

    public TestCaseTest(final String name) {
        super(name);
    }

    public static void main(final String[] args) throws Exception {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(TestCaseTest.class);
        final TestResult result = new TestResult();
        suite.run(result);
        TestCase.assertEquals("6 run, 0 failed", result.summary());
    }

    public void testTemplateMethod() throws Exception {
        final WasRun test = new WasRun("testMethod");
        test.run();
        assertEquals("setUp testMethod tearDown", test.log);
    }

    public void testResult() throws Exception {
        final WasRun test = new WasRun("testMethod");
        final TestResult result = test.run();
        assertEquals("1 run, 0 failed", result.summary());
    }

    public void testFailedResult() throws Exception {
        final WasRun test = new WasRun("testBrokenMethod");
        final TestResult result = test.run();
        assertEquals("1 run, 1 failed", result.summary());
    }

    public void testFailedResultFormatting() throws Exception {
        final TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        assertEquals("1 run, 1 failed", result.summary());
    }

    public void testSuite() throws Exception {
        final TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        final TestResult result = new TestResult();
        suite.run(result);
        assertEquals("2 run, 1 failed", result.summary());
    }

    public void testAddTestSuite() throws Exception {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(WasRun.class);
        final TestResult result = new TestResult();
        suite.run(result);
        assertEquals("1 run, 0 failed", result.summary());
    }
}
