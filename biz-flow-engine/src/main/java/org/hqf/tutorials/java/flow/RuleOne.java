package org.hqf.tutorials.java.flow;

import org.hqf.tutorials.java.flow.core.RuleContext;
import org.hqf.tutorials.java.flow.core.RuleTemplate;

import java.util.Set;

public class RuleOne extends RuleTemplate {

    public RuleOne(boolean async, Set<String> dependencies) {
        super("RuleOne", async, dependencies);
    }

    @Override
    public void applyRule(RuleContext context) {
        System.out.println("Executing RuleOne");
    }
}