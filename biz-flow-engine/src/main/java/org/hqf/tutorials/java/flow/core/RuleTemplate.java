package org.hqf.tutorials.java.flow.core;

import java.util.Set;

/**
 * @author Administrator
 */
public abstract class RuleTemplate {

    private final String name;
    private final boolean async;
    private final Set<String> dependencies;

    public RuleTemplate(String name, boolean async, Set<String> dependencies) {
        this.name = name;
        this.async = async;
        this.dependencies = dependencies;
    }

    public String getName() {
        return name;
    }

    public boolean isAsync() {
        return async;
    }

    public Set<String> getDependencies() {
        return dependencies;
    }

    public abstract void applyRule(RuleContext context);

    @Override
    public String toString() {
        return name;
    }
}