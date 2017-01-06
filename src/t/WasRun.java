package t;

public class WasRun extends TestCase {

    public String log;

    public WasRun() {
    }

    public WasRun(final String name) {
        super(name);
    }

    @Override
    protected void setUp() {
        log = "setUp ";
    }

    public void testMethod() {
        log += "testMethod ";
    }

    @Override
    protected void tearDown() {
        log += "tearDown";
    }

}
