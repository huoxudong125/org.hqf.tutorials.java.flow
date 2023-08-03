package org.hqf.tutorials.java.flow.core;

import java.util.*;
import java.util.stream.Collectors;

public class RuleGraph {

    private final Map<String, RuleNode> nodeMap;
    private final List<RuleNode> nodeList;

    public RuleGraph(List<RuleTemplate> rules) {
        nodeMap = new HashMap<>();
        nodeList = new ArrayList<>();

        // Create a node for each rule and add it to the node map
        for (RuleTemplate rule : rules) {
            RuleNode node = new RuleNode(rule);
            nodeMap.put(rule.getName(), node);
            nodeList.add(node);
        }

        // Add edges between nodes based on rule dependencies
        for (RuleNode node : nodeList) {
            for (String dependency : node.getRule().getDependencies()) {
                RuleNode depNode = nodeMap.get(dependency);
                depNode.addChild(node);
                node.addParent(depNode);
            }
        }
    }

    public List<RuleNode> getNodes() {
        return nodeList;
    }

    public List<RuleNode> getRootNodes() {
        return nodeList.stream().filter(RuleNode::isRoot).collect(Collectors.toList());
    }
}