package org.hqf.tutorials.java.flow;

import org.hqf.tutorials.java.flow.core.RuleContext;
import org.hqf.tutorials.java.flow.core.RuleTemplate;

import java.util.Set;

public class RuleThree extends RuleTemplate {

    public RuleThree(boolean async, Set<String> dependencies) {
        super("RuleThree", async, dependencies);
    }

    @Override
    public void applyRule(RuleContext context) {
        System.out.println("Executing RuleThree");
    }
}