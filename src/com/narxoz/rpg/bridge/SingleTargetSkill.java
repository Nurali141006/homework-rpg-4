package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

public class SingleTargetSkill extends Skill {
    public SingleTargetSkill(String skillName, int basePower, EffectImplementor effect) {
        super(skillName, basePower, effect);
    }

    @Override
    public void cast(CombatNode target) {
       CombatNode leaf = target.isAlive() && !target.getChildren().isEmpty()
                          ? target.getChildren().stream().filter(CombatNode::isAlive).findFirst().orElse(target)
                          : target;
        int dmg = resolvedDamage();
        leaf.takeDamage(dmg);
        System.out.println(leaf.getName() + " takes " + dmg + " " + getEffectName() + " damage!");
}
}
