package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

public class IceEffect implements EffectImplementor {
 public void apply(CombatNode target, int power) {
        int damage = computeDamage(power);
        target.takeDamage(damage);
        System.out.println(target.getName() + " takes " + damage + " ice damage!");
    }

    @Override
    public int computeDamage(int basePower) {
        return Math.max(0, (int) Math.round(basePower * 1.1));
    }

    @Override
    public String getEffectName() {
        return "Ice";
    }
}
