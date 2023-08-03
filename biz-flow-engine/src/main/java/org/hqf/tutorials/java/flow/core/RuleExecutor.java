package org.hqf.tutorials.java.flow.core;

import java.util.concurrent.CompletableFuture;

public interface RuleExecutor {
    CompletableFuture<Void> execute(RuleContext context, RuleTemplate rule);
}