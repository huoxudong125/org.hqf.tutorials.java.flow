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
        System.out.println("Executing RuleThree...");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Executing RuleThree ... " + i);
        }
        System.out.println("Executing RuleThree");
    }
}