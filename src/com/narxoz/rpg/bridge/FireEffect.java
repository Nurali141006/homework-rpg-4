package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

public class FireEffect implements EffectImplementor {

    @Override
    public void apply(CombatNode target, int power) {
        int damage = computeDamage(power);
        target.takeDamage(damage);
        System.out.println(target.getName() + " takes " + damage + " fire damage!");
    }

    @Override
    public String getEffectName() {
        return "Fire";
    }

    @Override
    public int computeDamage(int basePower) {
        return Math.max(0, (int) Math.round(basePower * 1.2));
    }
}