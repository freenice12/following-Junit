package t;

import java.util.ArrayList;
import java.util.List;

public class TestSuite extends TestCase {

    List<TestCase> tests = new ArrayList<>();

    public void add(final TestCase wasRun) {
        tests.add(wasRun);
    }

    @Override
    public TestResult run() {
        final TestResult result = new TestResult();
        for (final TestCase wasRun : tests) {
            wasRun.run(result);
        }
        return result;
    }

}
