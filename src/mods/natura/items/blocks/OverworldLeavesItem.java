package mods.natura.items.blocks;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.StatCollector;

public class OverworldLeavesItem extends ItemBlock
{
    public static final String blockType[] = { "maple", "silverbell", "purpleheart", "tiger" };

    public OverworldLeavesItem(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata (int md)
    {
        return md;
    }

    @Override
    public String getUnlocalizedName (ItemStack itemstack)
    {
        int i = MathHelper.clamp_int(itemstack.getItemDamage(), 0, 3);
        return (new StringBuilder()).append("block.leaves.").append(blockType[i]).toString();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        switch (stack.getItemDamage() % 4)
        {
        case 0:
            list.add(StatCollector.translateToLocal("tooltip.tree7"));
            break;
        case 1:
            list.add(StatCollector.translateToLocal("tooltip.tree8"));
            break;
        case 2:
            list.add(StatCollector.translateToLocal("tooltip.tree9"));
            break;
        case 3:
            list.add(StatCollector.translateToLocal("tooltip.tree10"));
            break;
        }
    }
}
