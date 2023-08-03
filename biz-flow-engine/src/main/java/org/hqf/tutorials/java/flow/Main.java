package org.hqf.tutorials.java.flow;

import org.hqf.tutorials.java.flow.core.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        RuleOne ruleOne = new RuleOne(true, Collections.emptySet());
        RuleTwo ruleTwo = new RuleTwo(true, Collections.singleton("RuleOne"));
        RuleThree ruleThree = new RuleThree(true, Collections.singleton("RuleTwo"));

        List<RuleTemplate> rules = Arrays.asList(ruleOne,ruleTwo, ruleThree);
        RuleGraph ruleGraph = new RuleGraph(rules);

        RuleExecutor ruleExecutor = new ParallelRuleExecutor();
        RuleEngine ruleEngine = new RuleEngine(ruleGraph, ruleExecutor);
        RuleContext context = new RuleContext();
        ruleEngine.executeAsync(context).join();

        System.out.println("Rules executed successfully");
    }
}