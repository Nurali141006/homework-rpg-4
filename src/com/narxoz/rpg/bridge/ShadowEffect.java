package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

public class ShadowEffect implements EffectImplementor {
     public void apply(CombatNode target, int power) {
        int damage = computeDamage(power);
        target.takeDamage(damage);
        System.out.println(target.getName() + " takes " + damage + " shadow damage!");
    }

    @Override
    public int computeDamage(int basePower) {
        return Math.max(0, (int) Math.round(basePower * 1.3));
    }

    @Override
    public String getEffectName() {
        return "Shadow";
    }
}
