package org.hqf.tutorials.java.flow;

import org.hqf.tutorials.java.flow.core.RuleContext;
import org.hqf.tutorials.java.flow.core.RuleTemplate;

import java.util.Set;

public class RuleTwo extends RuleTemplate {

    public RuleTwo(boolean async, Set<String> dependencies) {
        super("RuleTwo", async, dependencies);
    }

    @Override
    public void applyRule(RuleContext context) {
        System.out.println("Executing RuleTwo");
    }
}
