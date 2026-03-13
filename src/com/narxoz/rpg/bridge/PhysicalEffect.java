package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

public class PhysicalEffect implements EffectImplementor {
     public void apply(CombatNode target, int power) {
        int damage = computeDamage(power);
        target.takeDamage(damage);
        System.out.println(target.getName() + " takes " + damage + " physical damage!");
    }

    @Override
    public int computeDamage(int basePower) {
        return Math.max(0, basePower);
    }

    @Override
    public String getEffectName() {
        return "Physical";
    }
}
