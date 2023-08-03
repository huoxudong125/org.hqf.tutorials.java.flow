package org.hqf.tutorials.java.flow;


import org.hqf.tutorials.java.flow.core.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class RuleEngineTest {

    @Test
    public void testExecute() {
        RuleOne ruleOne = new RuleOne(false, Collections.emptySet());
        RuleTwo ruleTwo = new RuleTwo(false, Collections.singleton("RuleOne"));
        RuleThree ruleThree = new RuleThree(false, Collections.singleton("RuleTwo"));
        List<RuleTemplate> rules = Arrays.asList(ruleOne, ruleTwo, ruleThree);
        RuleGraph ruleGraph = new RuleGraph(rules);
        RuleExecutor ruleExecutor = new SequentialRuleExecutor();
        RuleEngine ruleEngine = new RuleEngine(ruleGraph, ruleExecutor);
        RuleContext context = new RuleContext();
        ruleEngine.execute(context);
    }

    @Test
    public void testExecuteAsync() {
        RuleOne ruleOne = new RuleOne(true, Collections.emptySet());
        RuleTwo ruleTwo = new RuleTwo(true, Collections.singleton("RuleOne"));
        RuleThree ruleThree = new RuleThree(true, Collections.singleton("RuleTwo"));
        List<RuleTemplate> rules = Arrays.asList(ruleOne, ruleTwo, ruleThree);
        RuleGraph ruleGraph = new RuleGraph(rules);
        RuleExecutor ruleExecutor = new ParallelRuleExecutor();
        RuleEngine ruleEngine = new RuleEngine(ruleGraph, ruleExecutor);
        RuleContext context = new RuleContext();
        ruleEngine.executeAsync(context).join();
    }

    @Test
    public void testExecuteAsyncWithInvalidRules() {
        RuleOne ruleOne = new RuleOne(false, Collections.emptySet());
        RuleTwo ruleTwo = new RuleTwo(false, Collections.singleton("RuleOne"));
        RuleThree ruleThree = new RuleThree(true, Collections.singleton("RuleTwo"));
        List<RuleTemplate> rules = Arrays.asList(ruleOne, ruleTwo, ruleThree);
        RuleGraph ruleGraph = new RuleGraph(rules);
        RuleExecutor ruleExecutor = new ParallelRuleExecutor();
        RuleEngine ruleEngine = new RuleEngine(ruleGraph, ruleExecutor);
        RuleContext context = new RuleContext();
        ruleEngine.executeAsync(context).join();
    }
}