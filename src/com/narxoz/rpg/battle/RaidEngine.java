package com.narxoz.rpg.battle;

import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.CombatNode;

import java.util.Random;

public class RaidEngine {
    private Random random = new Random(1L);

    public RaidEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public RaidResult runRaid(CombatNode teamA, CombatNode teamB, Skill teamASkill, Skill teamBSkill) {
         RaidResult result = new RaidResult();
        int round = 1;

        while (teamA.isAlive() && teamB.isAlive()) {
            result.addLine("=== Round " + round + " ===");

            if (teamA.isAlive() && teamB.isAlive()) {
                result.addLine("Team A uses skill on Team B:");
                teamASkill.cast(teamB);
            }
         if (teamB.isAlive() && teamA.isAlive()) {
                result.addLine("Team B uses skill on Team A:");
                teamBSkill.cast(teamA);
            }
       
            result.addLine("Team A status:");
            teamA.printTree("  ");
            result.addLine("Team B status:");
            teamB.printTree("  ");

            round++;
        }
         result.setRounds(round - 1);
        result.setWinner(teamA.isAlive() ? "Team A" : "Team B");
        return result;
    }
    }

