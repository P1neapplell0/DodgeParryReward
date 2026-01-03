package com.p1nero.dpr.skill;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

public class HealSkill extends ParryAndDodgeRewardSkill{
    protected double healCount;
    public HealSkill(Builder builder) {
        super(builder);
        playerPatchConsumer = playerPatch -> {
            if(!playerPatch.isLogicalClient()){
                Player player = playerPatch.getOriginal();
                player.heal((float) healCount);
            }
        };
    }

    @Override
    public void setParams(CompoundTag parameters) {
        super.setParams(parameters);
        if (parameters.contains("heal_count")) {
            healCount = parameters.getDouble("heal_count");
        }
    }

}
