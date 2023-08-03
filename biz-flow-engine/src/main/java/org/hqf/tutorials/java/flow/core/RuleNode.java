package org.hqf.tutorials.java.flow.core;

import java.util.ArrayList;
import java.util.List;

public class RuleNode {

    private final RuleTemplate rule;
    private final List<RuleNode> parents;
    private final List<RuleNode> children;

    public RuleNode(RuleTemplate rule) {
        this.rule = rule;
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    public RuleTemplate getRule() {
        return rule;
    }

    public List<RuleNode> getParents() {
        return parents;
    }

    public List<RuleNode> getChildren() {
        return children;
    }

    public void addParent(RuleNode parent) {
        parents.add(parent);
    }

    public void addChild(RuleNode child) {
        children.add(child);
    }

    public boolean isRoot() {
        return parents.isEmpty();
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public String toString() {
        return rule.getName();
    }
}