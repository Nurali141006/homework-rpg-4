package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

public interface EffectImplementor {
    int computeDamage(int basePower);
    void apply(CombatNode target, int power);
    String getEffectName();
    
}
