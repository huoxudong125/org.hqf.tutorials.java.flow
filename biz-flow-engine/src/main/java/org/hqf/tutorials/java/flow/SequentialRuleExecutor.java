package org.hqf.tutorials.java.flow;

import org.hqf.tutorials.java.flow.core.RuleContext;
import org.hqf.tutorials.java.flow.core.RuleExecutor;
import org.hqf.tutorials.java.flow.core.RuleTemplate;

import java.util.concurrent.CompletableFuture;

public class SequentialRuleExecutor implements RuleExecutor {

    @Override
    public CompletableFuture<Void> execute(RuleContext context, RuleTemplate rule) {
        return CompletableFuture.runAsync(() -> rule.applyRule(context));
    }
}