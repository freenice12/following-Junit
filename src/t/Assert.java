package t;

public class Assert {

    public static void assertEquals(final Object expected,
            final Object actual) {
        if (expected == null && actual == null) {
            return;
        }

        if (expected != null && expected.equals(actual)) {
            return;
        }

        fail();
    }

    public static void fail() {
        throw new AssertionFailedError();
    }

}
