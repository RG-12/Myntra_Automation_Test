package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Listener implements TestWatcher {
    private static final Logger log = LogManager.getLogger(Listener.class);

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
        System.out.println("Test was disabled.");
        log.info("Reason of Disabling: " + reason + " Context: " + context.getTestMethod());
        System.out.println("----------------");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
        System.out.println("Test was successfull!");
        log.info("Context: " + context.getTestMethod());
        System.out.println("----------------");
    }

    @Override
    public void testAborted(ExtensionContext context, @Nullable Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
        System.out.println("Test was aborted.");
        log.info("Abortion Cause: " + cause.getMessage() + " Context: " + context.getTestMethod());
        System.out.println("----------------");
    }

    @Override
    public void testFailed(ExtensionContext context, @Nullable Throwable cause) {
        TestWatcher.super.testFailed(context, cause);
        System.out.println("Test failed.");
        log.info("Failure Cause: " + cause.getMessage() + " Context: " + context.getTestMethod());
        System.out.println("----------------");
    }
}


