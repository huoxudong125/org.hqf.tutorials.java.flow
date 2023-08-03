package org.hqf.tutorials.java.flow.core;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class RuleEngine {

    private final RuleGraph ruleGraph;
    private final RuleExecutor ruleExecutor;

    public RuleEngine(RuleGraph ruleGraph, RuleExecutor ruleExecutor) {
        this.ruleGraph = ruleGraph;
        this.ruleExecutor = ruleExecutor;
    }

    public void execute(RuleContext context) {
        List<RuleNode> nodes = ruleGraph.getNodes();
        for (RuleNode node : nodes) {
            executeNode(context, node);
        }
    }

    public CompletableFuture<Void> executeAsync(RuleContext context) {
        List<RuleNode> rootNodes = ruleGraph.getRootNodes();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (RuleNode rootNode : rootNodes) {
            futures.add(executeNodeAsync(context, rootNode));
        }
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    private void executeNode(RuleContext context, RuleNode node) {
        RuleTemplate rule = node.getRule();
        if (rule.isAsync()) {
            throw new CustomException("Cannot execute asynchronous rule synchronously: " + rule.getName());
        }
        for (RuleNode parent : node.getParents()) {
            executeNode(context, parent);
        }
        ruleExecutor.execute(context, rule).join();
    }

    private CompletableFuture<Void> executeNodeAsync(RuleContext context, RuleNode node) {
        RuleTemplate rule = node.getRule();
        if (!rule.isAsync()) {
            throw new CustomException("Cannot execute synchronous rule asynchronously: " + rule.getName());
        }
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (RuleNode parent : node.getChildren()) {
            futures.add(executeNodeAsync(context, parent));
        }
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenCompose(ignore -> ruleExecutor.execute(context, rule));
    }
}